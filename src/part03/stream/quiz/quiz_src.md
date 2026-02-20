---
layout: part04
title: "확인문제"
nav_order: 99
parent: "Chapter 18. JDBC"
grand_parent: "데이터 입출력"
---

# 확인문제

1.  입출력 스트림에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 하나의 스트림으로 입력과 출력이 동시에 가능하다.
    *   ② 프로그램을 기준으로 데이터가 들어오면 입력 스트림이다.
    *   ③ 프로그램을 기준으로 데이터가 나가면 출력 스트림이다.
    *   ④ 콘솔에 출력하거나 파일에 저장하려면 출력 스트림을 사용해야 한다.
    > **정답**: ①
    > **해설**: 스트림은 단방향이다.

2.  InputStream과 Reader에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 이미지 데이터는 InputStream 또는 Reader로 모두 읽을 수 있다.
    *   ② Reader의 read() 메소드는 1문자를 읽는다.
    *   ③ InputStream의 read() 메소드는 1바이트를 읽는다.
    *   ④ InputStreamReader를 이용하면 InputStream을 Reader로 변환시킬 수 있다.
    > **정답**: ①
    > **해설**: 이미지 데이터는 바이너리 데이터이므로 바이트 스트림(InputStream)을 사용해야 한다. Reader는 문자 스트림이다.

3.  InputStream의 read(byte[] b) 메소드에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 메소드의 리턴값은 읽은 바이트 수이다.
    *   ② 매개값 b에는 읽은 데이터가 저장된다.
    *   ③ 읽을 수 있는 바이트 수는 제한이 없다.
    *   ④ 매개값 b에는 이전에 읽은 바이트가 남아 있을 수 있다.
    > **정답**: ③
    > **해설**: 읽을 수 있는 바이트 수는 배열 b의 길이로 제한된다.

4.  출력 스트림에서 데이터를 출력 후 flush() 메소드를 호출하는 이유는 무엇입니까?
    *   ① 출력 스트림의 버퍼에 있는 데이터를 모두 출력시키고 버퍼를 비운다.
    *   ② 출력 스트림을 메모리에서 제거한다.
    *   ③ 출력 스트림의 버퍼에 있는 데이터를 모두 삭제한다.
    *   ④ 출력 스트림을 닫는 역할을 한다.
    > **정답**: ①
    > **해설**: flush()는 버퍼에 남아있는 데이터를 강제로 출력한다.

5.  보조 스트림에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① InputStreamReader는 InputStream을 Reader로 변환시키는 보조 스트림이다.
    *   ② BufferedInputStream은 데이터 읽기 성능을 향상시키는 보조 스트림이다.
    *   ③ DataInputStream은 객체를 입출력하는 보조 스트림이다.
    *   ④ PrintStream은 print(), println() 메소드를 제공하는 보조 스트림이다.
    > **정답**: ③
    > **해설**: DataInputStream은 기본 타입 데이터를 입출력하는 보조 스트림이다. 객체 입출력은 ObjectInputStream/ObjectOutputStream이다.

6.  ObjectInputStream, ObjectOutputStream에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 객체를 직렬화해서 출력하고 역직렬화해서 복원시킨다.
    *   ② Serializable 인터페이스를 구현한 객체만 입출력할 수 있다.
    *   ③ 클래스의 serialVersionUID는 입출력할 때 달라도 상관없다.
    *   ④ transient 필드는 출력에서 제외된다.
    > **정답**: ③
    > **해설**: serialVersionUID가 같아야 역직렬화가 가능하다.

7.  소스 파일을 읽고 실행 결과와 같이 행의 라인 번호를 추가시켜 출력하도록 밑줄과 빈 곳에 코드를 작성해 보세요.
    ```java
    // ...
    String filePath = "C:/ThisIsJavaSecondEdition/workspace/thisisjava/src/ch02/sec01/VariableUseExample.java";
    FileReader fr = new FileReader(filePath);
    BufferedReader br = new BufferedReader(fr);
    int rowNumber = 0;
    String rowData;
    while (true) {
        rowData = br.readLine();
        if (rowData == null) break;
        System.out.println(++rowNumber + ": " + rowData);
    }
    br.close(); fr.close();
    // ...
    ```

8.  PrintStream에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① out 필드는 콘솔로 출력하는 PrintStream 타입이다.
    *   ② print(), println(), printf() 메소드를 제공한다.
    *   ③ println() 메소드는 매개값의 타입에 따라 오버로딩되어 있다.
    *   ④ PrintStream은 문자 기반 출력 스트림에 연결된다.
    > **정답**: ④
    > **해설**: PrintStream은 바이트 기반 출력 스트림에 연결된다. (PrintWriter가 문자 기반)

9.  File과 Files 클래스에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① File 객체는 파일이 실제로 존재하지 않아도 생성할 수 있다.
    *   ② File 객체는 파일 정보만 제공하고, 디렉토리 정보는 제공하지 않는다.
    *   ③ Files 클래스는 정적 메소드로 구성되어 있기 때문에 객체를 만들 필요가 없다.
    *   ④ File 객체는 파일의 크기를 제공하는 length() 메소드를 제공한다.
    > **정답**: ②
    > **해설**: File 객체는 파일뿐만 아니라 디렉토리 정보도 제공한다.

10. 실행하면 다음과 같이 원본 파일 경로와 복사 파일 경로를 입력받고 원본 파일을 복사하는 프로그램을 만들어 보세요. (바이트 기반 스트림과 성능 향상 보조 스트림을 반드시 사용)
    ```java
    package ch18.check;

    import java.io.*;
    import java.util.Scanner;

    public class FileCopy {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("원본 파일 경로: ");
            String originalFilePath = scanner.nextLine();

            System.out.print("복사 파일 경로: ");
            String targetFilePath = scanner.nextLine();

            File originalFile = new File(originalFilePath);
            if (!originalFile.exists()) {
                System.out.println("원본 파일이 존재하지 않습니다.");
                System.exit(0);
            }

            File targetFile = new File(targetFilePath);
            File parentFile = targetFile.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }

            try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(originalFilePath));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFilePath));
            ) {
                byte[] data = new byte[1024];
                int num;
                while ((num = bis.read(data)) != -1) {
                    bos.write(data, 0, num);
                }
                System.out.println("복사가 성공되었습니다.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    ```
