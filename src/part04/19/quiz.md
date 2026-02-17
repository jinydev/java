---
layout: part04
title: "확인문제"
nav_order: 99
parent: "Chapter 19. 네트워크 입출력"
grand_parent: "데이터 입출력"
---

# 확인문제

1.  서버와 클라이언트에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 서비스를 제공하는 쪽이 서버이고, 서비스를 요청하는 쪽이 클라이언트이다.
    *   ② 클라이언트가 서버에 연결하기 위해서는 IP 주소만 있으면 된다.
    *   ③ 포트(Port)는 여러 서버 중에 특정 서버와 연결하기 위해 필요한 정보다.
    *   ④ 서버와 클라이언트는 양쪽 모두 포트가 배정되어야 한다.
    > **정답**: ②
    > **해설**: IP 주소 외에도 포트 번호가 필요하다.

2.  TCP와 UDP에 대한 설명으로 틀린 것을 모두 선택하세요.
    *   ① TCP는 데이터 입출력에 앞서 연결 요청과 수락 과정이 필요하다.
    *   ② TCP는 여러 회선으로 데이터를 전달하므로, 데이터의 전달 순서가 달라질 수 있다.
    *   ③ UDP는 연결 수락 과정이 없기 때문에 TCP보다 상대적으로 빠르다.
    *   ④ UDP는 고정된 회선으로 데이터를 전달하기 때문에 전달 신뢰도가 높다.
    > **정답**: ②, ④
    > **해설**: TCP는 고정 회선을 사용하므로 순서가 보장된다. UDP는 고정 회선이 아니므로 데이터 순서가 달라질 수 있고 신뢰도가 낮다.

3.  다음은 TCP 클라이언트가 서버로 연결 요청을 하고 서버는 연결을 수락하는 코드이다. 빈칸에 들어갈 코드를 작성하세요. (단, 클라이언트와 서버는 같은 컴퓨터에서 실행하고 있습니다.)
    ```java
    // [클라이언트]
    Socket socket = new Socket("localhost", 5001);

    // [서버]
    ServerSocket serverSocket = new ServerSocket(5001);
    Socket socket = serverSocket.accept();
    ```

4.  TCP를 사용하는 클라이언트를 서버에 연결해 Socket으로 데이터 입출력을 하려고 합니다. 빈칸에 Socket을 통해 얻는 입출력 스트림의 타입을 적어 보세요.
    ```java
    InputStream is = socket.getInputStream();
    OutputStream os = socket.getOutputStream();
    ```

5.  UDP를 사용하는 클라이언트를 서버에서 사용되는 클래스 이름 및 데이터와 수신 · 발신할 때 사용되는 클래스 이름을 ① ~ ⑤ 빈칸에 작성해 보세요.
    *   ① `DatagramPacket`
    *   ② `DatagramSocket`
    *   ③ `DatagramPacket`
    *   ④ `DatagramPacket`
    *   ⑤ `DatagramSocket`

6.  서버 측 DatagramSocket에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 서버에서는 고정된 Port 번호를 제공하고 생성해야 한다.
    *   ② receive() 메소드는 데이터를 수신할 때까지 블로킹된다.
    *   ③ 클라이언트의 IP 주소와 Port 번호는 수신된 DatagramPacket에서 얻을 수 있다.
    *   ④ 클라이언트로 DatagramPacket을 발신할 때 write() 메소드를 사용한다.
    > **정답**: ④
    > **해설**: `send()` 메소드를 사용한다.

7.  상품관리 프로그램을 TCP를 이용해서 개발하려고 합니다. 다음 내용에 맞게 서버와 클라이언트를 직접 개발해 보세요.

    *(문제 내용 생략)*

    **요약**: Create, Update, Delete 기능을 가진 상품 관리 서버/클라이언트 구현. JSON 통신 사용.

    **Product.java**
    ```java
    package ch19.check;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.io.Serializable;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Product implements Serializable {
        private static final long serialVersionUID = 1L;
        private int no;
        private String name;
        private int price;
        private int stock;
    }
    ```

    **ProductServer.java** (서버 구현)
    ```java
    package ch19.check;

    import java.io.DataInputStream;
    import java.io.DataOutputStream;
    import java.io.IOException;
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.util.Collections;
    import java.util.List;
    import java.util.Vector;
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;

    import org.json.JSONArray;
    import org.json.JSONObject;

    public class ProductServer {
        private ServerSocket serverSocket;
        private ExecutorService threadPool;
        private List<Product> products;
        private int sequence;

        public void start() throws IOException {
            serverSocket = new ServerSocket(50001);
            threadPool = Executors.newFixedThreadPool(100);
            products = new Vector<>();

            System.out.println("[서버] 시작됨");

            while(true) {
                Socket socket = serverSocket.accept();
                SocketClient sc = new SocketClient(this, socket);
            }
        }

        public void stop() {
            try {
                serverSocket.close();
                threadPool.shutdownNow();
                System.out.println("[서버] 종료됨");
            } catch (IOException e1) {}
        }

        public static void main(String[] args) {
            try {
                ProductServer productServer = new ProductServer();
                productServer.start();
            } catch (IOException e) {
                System.out.println("[서버] " + e.getMessage());
            }
        }

        // 중첩 클래스
        public class SocketClient {
            private ProductServer productServer;
            private Socket socket;
            private DataInputStream dis;
            private DataOutputStream dos;

            public SocketClient(ProductServer productServer, Socket socket) {
                try {
                    this.productServer = productServer;
                    this.socket = socket;
                    this.dis = new DataInputStream(socket.getInputStream());
                    this.dos = new DataOutputStream(socket.getOutputStream());
                    receive();
                } catch (IOException e) {
                    close();
                }
            }

            public void receive() {
                productServer.threadPool.execute(() -> {
                    try {
                        while(true) {
                            String requestJson = dis.readUTF();
                            JSONObject request = new JSONObject(requestJson);
                            int menu = request.getInt("menu");

                            switch(menu) {
                                case 0:
                                    list();
                                    break;
                                case 1:
                                    create(request);
                                    break;
                                case 2:
                                    update(request);
                                    break;
                                case 3:
                                    delete(request);
                                    break;
                            }
                        }
                    } catch(Exception e) {
                        close();
                    }
                });
            }

            public void list() throws IOException {
                JSONArray data = new JSONArray();
                for(Product p : productServer.products) {
                    JSONObject product = new JSONObject();
                    product.put("no", p.getNo());
                    product.put("name", p.getName());
                    product.put("price", p.getPrice());
                    product.put("stock", p.getStock());
                    data.put(product);
                }

                JSONObject response = new JSONObject();
                response.put("status", "success");
                response.put("data", data);
                dos.writeUTF(response.toString());
                dos.flush();
            }

            public void create(JSONObject request) throws IOException {
                JSONObject data = request.getJSONObject("data");
                Product product = new Product();
                product.setNo(++productServer.sequence);
                product.setName(data.getString("name"));
                product.setPrice(data.getInt("price"));
                product.setStock(data.getInt("stock"));
                productServer.products.add(product);

                list();
            }

            public void update(JSONObject request) throws IOException {
                JSONObject data = request.getJSONObject("data");
                int no = data.getInt("no");
                for(int i=0; i<productServer.products.size(); i++) {
                    Product product = productServer.products.get(i);
                    if(product.getNo() == no) {
                        product.setName(data.getString("name"));
                        product.setPrice(data.getInt("price"));
                        product.setStock(data.getInt("stock"));
                    }
                }
                list();
            }

            public void delete(JSONObject request) throws IOException {
            	JSONObject data = request.getJSONObject("data");
                int no = data.getInt("no");
                for(int i=0; i<productServer.products.size(); i++) {
                    Product product = productServer.products.get(i);
                    if(product.getNo() == no) {
                        productServer.products.remove(i);
                    }
                }
                list();
            }

            public void close() {
                try {
                	socket.close();
                } catch(Exception e) {}
            }
        }
    }
    ```

    **ProductClient.java** (클라이언트 구현)
    ```java
    package ch19.check;

    import java.io.DataInputStream;
    import java.io.DataOutputStream;
    import java.io.IOException;
    import java.net.Socket;
    import java.util.Scanner;

    import org.json.JSONArray;
    import org.json.JSONObject;

    public class ProductClient {
        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;
        private Scanner scanner;

        public void start() throws IOException {
            socket = new Socket("localhost", 50001);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);
            
            list();
        }

        public void stop() {
            try {
                socket.close();
                scanner.close();
            } catch(Exception e) {}
            System.out.println("[클라이언트] 종료");
        }

        public void list() throws IOException {
            System.out.println("\n[상품 목록]");
            System.out.println("--------------------------------------------------");
            System.out.println("no\tname\t\tprice\tstock");
            System.out.println("--------------------------------------------------");
            
            // 서버에 목록 요청
            JSONObject request = new JSONObject();
            request.put("menu", 0);
            request.put("data", new JSONObject());
            dos.writeUTF(request.toString());
            dos.flush();
            
            // 응답 받기
            String responseJson = dis.readUTF();
            JSONObject response = new JSONObject(responseJson);
            if(response.getString("status").equals("success")) {
            	JSONArray data = response.getJSONArray("data");
            	for(int i=0; i<data.length(); i++) {
            		JSONObject product = data.getJSONObject(i);
            		System.out.println(
            			product.getInt("no") + "\t" + 
            			product.getString("name") + "\t" + 
            			product.getInt("price") + "\t" + 
            			product.getInt("stock")
            		);
            	}
            }
            
            menu();
        }

        public void menu() throws IOException {
            System.out.println("--------------------------------------------------");
            System.out.println("메뉴: 1.Create | 2.Update | 3.Delete | 4.Exit");
            System.out.print("선택: ");
            String menuNo = scanner.nextLine();
            switch(menuNo) {
                case "1": create(); break;
                case "2": update(); break;
                case "3": delete(); break;
                case "4": stop(); return;
            }
        }

        public void create() throws IOException {
            System.out.println("[상품 생성]");
            Product product = new Product();
            System.out.print("상품 이름: ");
            product.setName(scanner.nextLine());
            System.out.print("상품 가격: ");
            product.setPrice(Integer.parseInt(scanner.nextLine()));
            System.out.print("상품 재고: ");
            product.setStock(Integer.parseInt(scanner.nextLine()));

            JSONObject data = new JSONObject();
            data.put("name", product.getName());
            data.put("price", product.getPrice());
            data.put("stock", product.getStock());

            JSONObject request = new JSONObject();
            request.put("menu", 1);
            request.put("data", data);

            dos.writeUTF(request.toString());
            dos.flush();
            
            // 응답 대기 및 목록 갱신
            String responseJson = dis.readUTF();
            JSONObject response = new JSONObject(responseJson);
            if(response.getString("status").equals("success")) {
            	list();   
            }
        }
        
        public void update() throws IOException {
            System.out.println("[상품 수정]");
            Product product = new Product();
            System.out.print("상품 번호: ");
            product.setNo(Integer.parseInt(scanner.nextLine()));
            System.out.print("이름 변경: ");
            product.setName(scanner.nextLine());
            System.out.print("가격 변경: ");
            product.setPrice(Integer.parseInt(scanner.nextLine()));
            System.out.print("재고 변경: ");
            product.setStock(Integer.parseInt(scanner.nextLine()));

            JSONObject data = new JSONObject();
            data.put("no", product.getNo());
            data.put("name", product.getName());
            data.put("price", product.getPrice());
            data.put("stock", product.getStock());

            JSONObject request = new JSONObject();
            request.put("menu", 2);
            request.put("data", data);

            dos.writeUTF(request.toString());
            dos.flush();

            // 응답 대기 및 목록 갱신
            String responseJson = dis.readUTF();
            JSONObject response = new JSONObject(responseJson);
            if(response.getString("status").equals("success")) {
            	list();   
            }
        }

        public void delete() throws IOException {
            System.out.println("[상품 삭제]");
            System.out.print("상품 번호: ");
            int no = Integer.parseInt(scanner.nextLine());

            JSONObject data = new JSONObject();
            data.put("no", no);

            JSONObject request = new JSONObject();
            request.put("menu", 3);
            request.put("data", data);

            dos.writeUTF(request.toString());
            dos.flush();

            // 응답 대기 및 목록 갱신
            String responseJson = dis.readUTF();
            JSONObject response = new JSONObject(responseJson);
            if(response.getString("status").equals("success")) {
            	list();   
            }
        }

        public static void main(String[] args) {
            try {
                ProductClient productClient = new ProductClient();
                productClient.start();
            } catch(Exception e) {
            	e.printStackTrace();
            	System.out.println("[클라이언트] 서버 연결 안됨");
            }
        }
    }
    ```
