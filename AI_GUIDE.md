# AI를 위한 프로젝트 구조 가이드

이 문서는 AI 어시스턴트가 이 프로젝트의 구조와 규칙을 이해하고, 효율적으로 작업을 수행할 수 있도록 돕기 위해 작성되었습니다.

## 1. 프로젝트 개요
이 프로젝트는 "객체지향 자바 프로그래밍" 강의자료를 웹사이트로 호스팅하기 위한 Jekyll 기반 프로젝트입니다. 

## 2. 디렉토리 구조 및 역할

- **src (Root Source)**: 모든 컨텐츠와 소스 코드는 이곳에 위치합니다.
    - **_layouts**:
        - `bootstrap.html`: 기본 HTML 골격 (css, js 로드)
        - `default.html`: 일반적인 페이지 레이아웃
        - `docs.html`: 문서 페이지 레이아웃 (사이드바 포함)
        - `home.html`: 메인 대시보드형 레이아웃
    - **_includes**:
        - `head.html`, `scripts.html`: 공통 헤더 및 스크립트
        - `header.html`, `footer.html`: 상단 및 하단 네비게이션
        - `nav.html`: 사이드바 네비게이션 로직 (활성 상태 자동 확장 포함)
    - **_data**:
        - `navigation.yml`: 사이드바 메뉴 구조 정의. (Nested layout 지원)
    - **assets**:
        - `css/styles.scss`: 커스텀 스타일 정의
        - `js/`: 커스텀 스크립트
        - `img/`: 이미지 리소스

## 3. 주요 규칙

### 네비게이션 (Navigation)
- `src/_data/navigation.yml` 파일에서 관리됩니다.
- 2단계 깊이의 중첩 구조를 지원합니다 (`main` > `subitems`).
- **확장 로직**: `src/_includes/nav.html`에는 현재 페이지 URL을 기반으로 메뉴를 자동으로 펼치고 활성화하는 로직이 포함되어 있습니다. (URL 매칭 시 `.html`, `index`, trailing slash 제거 등 로버스트한 매칭 사용)

### 레이아웃 할당
- `_config.yml`의 `defaults` 설정을 통해 기본적으로 `layout: docs`가 적용됩니다.
- 대문 페이지나 특수 페이지는 Front Matter에서 `layout: home` 등을 명시적으로 지정할 수 있습니다.

### 파일명 및 URL
- Jekyll의 `kramdown` 파서를 사용합니다.
- `permalink` 설정에 따라 URL 구조가 결정되므로, 파일명과 폴더구조를 체계적으로 유지해야 합니다.

## 4. 작업 시 참고사항

- **새로운 챕터 추가 시**:
    1. `src` 내에 `NN_chaptername` 형식의 폴더 생성
    2. `index.md` 작성
    3. `src/_data/navigation.yml`에 항목 추가
- **이미지 추가 시**: `src/assets/img` 경로 사용 권장

이 가이드를 참고하여 일관성 있는 구조를 유지해 주시기 바랍니다.
