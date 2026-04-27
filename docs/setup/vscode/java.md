# Coding Pack for Java 설치

vscode 의 코딩 자바 패키지로 손쉽개 자바 개발 환경을 구축 할 수 있습니다.



## 친숙한 VSCode 개발환경

이제 그동안 불편한 이클립스를 벗어나 `VSCode` 개발 환경으로 AI 와 협업한 자바 개발 환경을 구축할 수 있습니다.



## 설치진행 단계



### 라이센스 동의

![image-20260226223917314](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226223917314.png)





### 구성요소 및 설정

![image-20260226224056716](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226224056716.png)



### 설치과정

![image-20260226224124336](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226224124336.png)



### 자바 SDK 자동 설치

![image-20260226224441191](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226224441191.png)



### 설치 완료

![image-20260226224638543](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226224638543.png)





### 설치확인

터미널을 실행하여 자바가 정상적으로 설치가 되어 있는지 확인 합니다.



![image-20260226225027604](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226225027604.png)



## VSCode 확장 패키지 설치하기

vscode 에서 자바를 보다 편리하게 개발하기 위한 확장 패키지도 같이 설치가 되었습니다. 만일, 설치가 아직 되어 있지 않다면 `Java Extionsion Pack`을 같이 설치 합니다.

![image-20260226224732573](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226224732573.png)



## VSCode 에서 프로젝트 실행하기





명령 팔레트를 실행하여 프로젝트를 생성합니다. 



ctrl + shift + p



![image-20260226225200358](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226225200358.png)



### 빌드 옵션



![image-20260226225243661](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226225243661.png)



### 프로젝트 폴더 지정

![image-20260226225338399](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226225338399.png)



### 프로젝트 이름

![image-20260226225419968](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226225419968.png)



### 자동 생성되는 프로젝트 구조



![image-20260226225506823](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226225506823.png)



### 코드확인

기본 예제 코드도 같이 잘 작성이 되어 있습니다.

![image-20260226225543874](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226225543874.png)



```
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
```



### 컴파일 및 실행하기

소스코드 상단에 있는 실행버튼을 클릭 합니다.

![image-20260226225630124](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226225630124.png)



또는 `F5`를 눌러 실행합니다.



#### 권환을 허용합니다.

![image-20260226225715120](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226225715120.png)



#### 실행결과 확인

하단 터미널 창에 실행된 결과가 출력 됩니다.

![image-20260226225824766](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226225824766.png)



```
PS D:\lecture\java\test\HelloJava\HelloJava>  & 'C:\Program Files\Eclipse Adoptium\jdk-17.0.18.8-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'D:\lecture\java\test\HelloJava\HelloJava\bin' 'App' 
Hello, World!
```





#### 소스코드 지정하여 실행하기

소스코드를 선택하고 마우스 오른쪽 키를 선택하면, 다음과 같이 메뉴가 출력 됩니다. 

![image-20260226225920390](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226225920390.png)

`Run Java`를 선택하여 실행할 수 있습니다.



## 코파일럿 실행

VSCode 에는 기본적으로 AI 개발자 도구인 코파일럿이 기본 탑제되어 있습니다.

![image-20260226230148526](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260226230148526.png)



AI 도구를 활용하여 도움을 받으면서 코드를 같이 개발 할 수 있습니다.