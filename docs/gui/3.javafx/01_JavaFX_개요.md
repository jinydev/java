# 01. JavaFX 개요

JavaFX는 자바 기반 UI 애플리케이션Rich Client Application을 개발할 때 사용할 수 있는 그래픽과 미디어

모듈을 말한다. 자바의 UI 라이브러리의 변천 과정은 다음과 같다.

AWT

자바 언어가 탄생한 1995년에는 인터넷이 활성화되지 않았기 때문에 대부분의 클라이언트 애플리

케이션은 운영체제가 제공하는 네이티브native UI 컴포넌트를 이용해서 개발되었다. 그래서 Java 1.0

에 포함된 AWTAbstract Window Toolkit는 운영 체제가 제공하는 네이티브 UI 컴포넌트를 이용하는 자바

라이브러리였다. 그렇다 보니 자바 애플리케이션이 실행되는 운영체제에 따라 UI의 모양이 서로 달

랐고, 종류도 제한적이었다.

Swing

AWT의 다음 주자로 Swing이 등장했다. Swing의 중심 아이디어는 운영체제가 제공하는 네이티

브 UI 컴포넌트를 사용하지 말자는 것이었다. 즉 모든 운영체제상에서 동일한 UI를 갖도록, Swing

자신만의 UI (look and feel )를 갖도록 했다. 그렇다 보니 실행 성능이 느려지고, 메모리를 더 많

이 사용하게 되었다. 시간이 흘러 네이티브 UI가 애니메이션과 다양한 시각적인 효과를 내면서 사

용자는 Swing의 UI보다는 운영체제의 네이티브 UI를 더 선호하게 되었다. 그래서 Swing은 점점

네이티브 UI에 밀려나기 시작했다.

JavaFX

JavaFX는 Java 기반의 데스크톱, 모바일 및 임베디드 시스템을 위한 오픈 소스 차세대 UI 클라이

언트 애플리케이션 플랫폼이다. JavaFX는 자바 코드와 분리해서 스타일 시트(CSS )를 작성할 수

있기 때문에 테마를 쉽게 변경할 수 있고, 안드로이드처럼 화면 레이아웃과 비즈니스 로직을 분리할

수 있기 때문에 Swing보다는 편리하게 디자인을 할 수 있다는 장점이 있다. 다음은 JavaFX 애플리

케이션을 구성하는 파일 단위 요소를 보여준다.

JavaFX 애플리케이션 구성 요소

[레이아웃]
자바 코드 파일
또는
FXML 파일

[외관 및 스타일]
CSS 파일

[비즈니스 로직]
자바 코드 파일

[리소스]
그림 파일
동영상 파일
…


JavaFX 설치

JavaFX는 Java 7과 Java 8에서는 JDK에 포함되어 있지만, Java 11부터 JDK에 포함되지 않고

오픈 소스 모듈로 진화하였다. 따라서 JavaFX를 사용하려면 별도의 설치 작업이 필요하다. JavaFX

모듈 설치 파일은 다음 URL에서 다운로드할 수 있다.

https ://gluonhq.com/products/javafx

장기 지원Long Term Support, LTS 버전을 받는 것이 좋기 때문에 21.0.1 [LTS] 버전을 선택한다. 운영체제

와 CPU 아키텍처는 사용하는 PC에 따라 선택하고, 타입은 SDK를 선택한다.

JavaFX 버전은 다운로드하는 시점에 따라 달라질 수 있다.

윈도우 운영체제용 설치 파일은 압축 파일(zip ) 형식으로 되어 있다. 압축을 해제하면 다음 폴더가

나온다.

javafx -sdk -21.0.1

이 폴더를 다음 경로로 이동시킨다.

C :\ThisisJava\javafx -sdk -21.0.1

javafx-sdk-21.0.1 폴더 내부를 보면 lib 폴더가 있다. 이 폴더에는 JavaFX에서 제공하는 모듈

파일(JAR )이 있다. 이들 모듈에 포함되어 있는 패키지와 패키지 내부의 클래스 및 인터페이스를 보

려면 API 도큐먼트가 필요하다. API 도큐먼트는 다음 URL에서 볼 수 있다. 학습할 때 언제든지 참

고할 수 있도록 웹 브라우저 북마크(즐겨찾기)에 추가해 두자.

https ://openjfx.io/javadoc/21



Scene Builder 설치

씬 빌더Scene Builder는 드래그 앤 드롭 사용자 인터페이스 디자인 방식으로 JavaFX의 화면 레이아웃

FXML 파일을 자동 생성해주는 오픈 소스 도구이다. Scene Builder 설치 파일은 다음 URL에서

다운로드할 수 있다.

https ://gluonhq.com/products/scene -builder

사용하는 PC의 운영체제에 따라 설치 파일을 다운로드한다.

설치 과정에서 윈도우 운영체제에서의 설치 경로를 다음과 같이 변경해 준다.

C :\ThisisJava\javafx -sdk -21.0.1\SceneBuilder


설치 완료 후 다음 파일을 더블 클릭하면 Scene Builder가 실행된다.

C :\ThisisJava\javafx -sdk -21.0.1\SceneBuilder\SceneBuilder.exe

Empty 템플릿을 선택하면 다음과 같은 FXML 편집기가 실행된다. 편집기 실행을 확인하고 우측

상단에 있는 종료 버튼(

)을 클릭해서 편집기를 닫는다.

e(fx)clipse 설치

e (fx )clipse는 JavaFX 개발도구를 제공해 주는 이클립스 플러그인이다. 프로젝트 생성 및 자동 완

성, FXML 파일을 Scene Builder로 열기 등의 기능을 제공하기 때문에 매우 편리하다.



이클립스 메뉴에서 [Help] - [Install New Software…]를 선택하고, [work with:]에 ‘https://

download.eclipse.org/efxclipse/updates-nightly/site/’를 입력하고 [Add…] 버튼을 클

릭하면 다음과 같은 [Add Repository] 대화상자를 확인할 수 있다. 대화상자의 [Name:]에

‘efxclipse’라고 입력하고 [Add] 버튼을 클릭해 설치한다.

e (fx )clipse는 3.10 버전 이상을 설치해야 하지만, 현재는 아직 nightly 버전에 해당하므로 정식 버전이 출시

되면 [Eclipse Marketplace…]에서 설치할 수 있을 것이다.

이클립스 메뉴에서 [Window] - [Preferences]를 선택한다. 왼쪽 항목에서 JavaFX를 선택하면

다음과 같이 SceneBuilder 실행 파일 경로와 JavaFX SDK 경로를 입력하는 내용이 나온다.

입력란에서 [Browse] 버튼을 클릭해 다음 경로의 파일을 선택해준다.

SceneBuilder executable

C :\ThisisJava\javafx -sdk -21.0.1\SceneBuilder\SceneBuilder.exe

JavaFX 11 + SDK

C :\ThisisJava\javafx -sdk -12.0.1\lib

[Apply and Close] 버튼을 클릭해 적용한다.


