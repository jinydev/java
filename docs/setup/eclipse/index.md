# Eclipse (이클립스) 소개 및 설치 가이드

## 1. Eclipse (이클립스)란?

**Eclipse(이클립스)**는 Java 개발에 가장 널리 사용되는 대표적인 무료 오픈소스 통합 개발 환경(IDE)입니다. 초창기 IBM에 의해 개발되었으나 이후 Eclipse 재단으로 넘어가 전 세계 개발자들의 기여로 발전해 왔습니다.

**주요 특징:**
* **강력한 Java 지원**: 코딩, 디버깅, 컴파일 등 Java 개발에 필요한 모든 기능을 완벽하게 지원합니다.
* **풍부한 플러그인 생태계**: 마켓플레이스를 통해 웹 개발(Spring, JSP 등), 데이터베이스 연동, Git 등 다양한 기능을 플러그인 형태로 추가할 수 있어 확장성이 매우 뛰어납니다.
* **실무 표준**: 오랜 기간 수많은 기업과 개발자들에게 검증된 도구로, 국내 IT 실무(특히 SI 및 금융권 등)에서 표준 개발 환경으로 가장 많이 사용됩니다.

---

## 2. Eclipse 다운로드 

공식 홈페이지를 통해 윈도우(Windows 64-bit)용 설치 파일을 받아 설치할 수 있습니다. 이미 Java 환경이 포함된 인스톨러를 사용하면 편리합니다.



![image-20260227021410574](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227021410574.png)





* 📥 **[Eclipse Installer 다운로드 링크 (클릭)](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2025-12/R/eclipse-inst-jre-win64.exe&mirror_id=1287)**

> 위 링크를 클릭하면 `eclipse-inst-jre-win64.exe` 파일이 다운로드됩니다.

---

## 3. Eclipse 설치 과정

1. 다운로드 받은 **`eclipse-inst-jre-win64.exe`** 파일을 더블 클릭하여 실행합니다.
2. **Eclipse Installer** 창이 열리면, 다양한 패키지 목록이 나타납니다.
   * 단순히 순수 Java 문법만 공부한다면 **`Eclipse IDE for Java Developers`**를 선택해도 됩니다.
   * 하지만 향후 웹 개발(JSP, Spring 등)이나 엔터프라이즈급 개발까지 고려한다면 **`Eclipse IDE for Enterprise Java and Web Developers`**를 선택하는 것을 권장합니다.
3. **설치 옵션 확인**: 
   * 최상단의 `Java 17+ VM` 항목 아래에 `Installation Folder`(설치 경로)가 나타납니다. 확인 후 **[INSTALL]** 버튼을 클릭합니다.
4. **라이선스 동의**: 
   * 라이선스(Oomph License Agreement 등) 창이 뜨면 **[Accept Now]** (또는 Accept) 버튼을 클릭하여 동의합니다.
5. **설치 진행 및 완료**: 
   * 설치가 진행되며 어느 정도 시간이 소요될 수 있습니다. 
   * 설치가 완료되면 초록색 **[LAUNCH]** 버튼이 나타납니다. 이를 클릭하여 이클립스를 처음으로 실행합니다.



![image-20260227021440530](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227021440530.png)



![image-20260227021456050](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227021456050.png)



![image-20260227021507022](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227021507022.png)



![image-20260227021517001](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227021517001.png)



![image-20260227021632131](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227021632131.png)





---

## 4. 첫 실행 시 Workspace(작업 공간) 설정

Eclipse를 실행할 때마다 혹은 최초 실행 시 **Workspace (작업 공간)**를 지정하는 창이 뜹니다.



![image-20260227021701268](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227021701268.png)



* **Workspace**는 앞으로 작성할 Java 소스 코드 파일과 프로젝트 설정 파일들이 저장될 최상위 폴더입니다.
* 기본적으로 `C:\Users\계정명\eclipse-workspace` 등으로 잡혀 있지만, 관리하기 편한 폴더(예: `D:\lecture\java\src` 등)로 변경하셔도 좋습니다.



> D:\lecture\java\eclipse-workspace 워크스페이스 폴더를 생성합니다.
>
> ![image-20260227021813081](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227021813081.png)
>
> ![image-20260227021828411](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227021828411.png)





* 매번 창이 뜨는 것이 번거롭다면 **"Use this as the default and do not ask again"** 체크박스를 선택한 후 **[Launch]** 버튼을 누릅니다.



## 이클립스 화면



![image-20260227021912249](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227021912249.png)



## 프로젝트 생성



이제 Eclipse가 정상적으로 실행되며, 상단 메뉴의 `File` > `New` > `Java Project`를 통해 첫 자바 프로젝트를 시작하실 수 있습니다!



![image-20260227021942123](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227021942123.png)



`java_study` 프로젝트를 생성합니다.

![image-20260227022203453](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227022203453.png)



최신 자바 버젼을 선택 합니다.

![image-20260227022224190](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227022224190.png)



새로운 프로젝트가 생성이 되었습니다.

![image-20260227022252861](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227022252861.png)



새로운 패키지를 추가 합니다.

![image-20260227022320031](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227022320031.png)



이름을 설정합니다. 패키지명으로 지정합니다.

![image-20260227022402486](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227022402486.png)

새로운 패키지가 추가되었습니다.

![image-20260227022500777](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227022500777.png)



새로운 클래스를 추가 합니다.

![image-20260227022524288](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227022524288.png)



Hello 클래스를 생성합니다.



![image-20260227022628470](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227022628470.png)



기본 골격의 클래스 파일이 하나 만들어 집니다.

![image-20260227022655194](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227022655194.png)



다음과 같이 코드를 작성합니다.

```java
package ch01.sec08;

public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello Java");

	}

}
```



실행 버튼을 클릭 합니다.

![image-20260227022810970](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227022810970.png)



하단에 결과가 출력 됩니다.

![image-20260227022835056](C:\Users\infoh\AppData\Roaming\Typora\typora-user-images\image-20260227022835056.png)
