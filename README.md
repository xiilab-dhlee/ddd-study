## 🎯 프로젝트 개요

이 프로젝트는 Cursor와 같은 현대적인 코드 에디터(IDE)의 핵심 기능들을 DDD(Domain-Driven Design) 패턴으로 구현한 예제입니다. 10개의 바운디드 컨텍스트로 구성되어 있으며, 각 컨텍스트는 명확하게 분리된 책임과 기능을 가지고 있습니다.

### 📁 프로젝트 위치
```
src/main/java/com/ide/
```

---

## 🏗️ 10개 바운디드 컨텍스트

### 1. Editor (편집기)
**목적**: 코드 작성, 편집, 시각화의 핵심 영역

**주요 기능**:
- 텍스트 편집 (삽입, 삭제, 교체)
- 구문 강조 (Syntax Highlighting)
- 코드 포맷팅
- 멀티 커서
- 코드 폴딩
- 미니맵

**핵심 도메인 모델**:
- `Editor`: 에디터 애그리게이트 루트
- `TextContent`: 텍스트 내용 값 객체
- `CursorPosition`: 커서 위치
- `FormattingRule`: 포맷팅 규칙
- `ProgrammingLanguage`: 프로그래밍 언어 열거형

**서비스**:
- `OpenEditorService`: 에디터 열기
- `EditTextService`: 텍스트 편집

**이벤트**:
- `EditorOpenedEvent`
- `TextEditedEvent`
- `DocumentFormattedEvent`

---

### 2. Language Intelligence (언어 지능)
**목적**: 언어별 분석, 이해, 제안 기능

**주요 기능**:
- 코드 완성 (Code Completion)
- 인라인 힌트
- 리팩토링 제안
- 타입 추론
- 정의로 이동
- 오류 진단

**핵심 도메인 모델**:
- `CodeCompletion`: 코드 완성 애그리게이트
- `CompletionItem`: 완성 항목 값 객체
- `Diagnostic`: 진단 정보
- `RefactoringType`: 리팩토링 유형

**서비스**:
- `CodeCompletionService`: 코드 완성 서비스

**이벤트**:
- `CompletionSelectedEvent`

**Cursor 연관**: @codebase, @docs, AI 완성 기능

---

### 3. Project Management (프로젝트 관리)
**목적**: 워크스페이스, 파일 시스템, 프로젝트 구조 관리

**주요 기능**:
- 파일 탐색기
- 워크스페이스 관리
- Git 통합
- 검색 및 탐색
- 북마크

**핵심 도메인 모델**:
- `Workspace`: 워크스페이스 애그리게이트 루트
- `FileNode`: 파일/디렉토리 노드
- `WorkspaceId`: 워크스페이스 식별자

**서비스**:
- `WorkspaceService`: 워크스페이스 생성 및 관리

**이벤트**:
- `WorkspaceCreatedEvent`
- `FolderAddedEvent`
- `FolderRemovedEvent`
- `GitEnabledEvent`

**Cursor 연관**: 사이드바, 파일 트리, 워크스페이스 폴더

---

### 4. Agent & Automation (에이전트 및 자동화)
**목적**: 사용자의 의도를 이해하고 작업을 대신 수행하는 지능형 에이전트

**주요 기능**:
- 코드 생성
- 버그 수정
- 테스트 생성
- 문서화
- 리팩토링 실행
- 터미널 명령 실행

**핵심 도메인 모델**:
- `AgentTask`: 에이전트 작업 애그리게이트 루트
- `AgentTaskType`: 작업 유형 (CODE_GENERATION, BUG_FIX, etc.)
- `AgentTaskStatus`: 작업 상태 (PENDING, IN_PROGRESS, COMPLETED, FAILED)

**서비스**:
- `AgentTaskService`: 에이전트 작업 관리

**이벤트**:
- `AgentTaskCreatedEvent`
- `AgentTaskStartedEvent`
- `AgentTaskCompletedEvent`
- `AgentTaskFailedEvent`

**Cursor 연관**: Cursor Agent, Chat, Composer

---

### 5. Extensions (확장 시스템)
**목적**: 서드파티 기능 추가 및 생태계 확장

**주요 기능**:
- 마켓플레이스
- 확장 설치/관리
- 확장 API 제공
- 테마/아이콘 확장

**핵심 도메인 모델**:
- `Extension`: 확장 애그리게이트 루트
- `ExtensionStatus`: 확장 상태 (AVAILABLE, INSTALLED, DISABLED, UPDATING)

**서비스**:
- `ExtensionService`: 확장 설치 및 관리

**이벤트**:
- `ExtensionInstalledEvent`
- `ExtensionUninstalledEvent`
- `ExtensionEnabledEvent`
- `ExtensionDisabledEvent`

**Cursor 연관**: 확장 마켓플레이스 (VS Code 호환)

---

### 6. AI Services (AI 서비스)
**목적**: LLM과의 연결, 프롬프트 관리, 모델 선택

**주요 기능**:
- 모델 선택 (GPT-4o, Claude 3.5, etc)
- 프롬프트 템플릿
- 컨텍스트 관리 (@files, @codebase)
- 비용 추적

**핵심 도메인 모델**:
- `AIModel`: AI 모델 애그리게이트 루트
- `AIProvider`: AI 제공자 (OPENAI, ANTHROPIC, GOOGLE, etc.)
- `PromptTemplate`: 프롬프트 템플릿

**서비스**:
- `AIModelService`: AI 모델 관리

**이벤트**:
- `AIModelActivatedEvent`
- `AIModelDeactivatedEvent`

**Cursor 연관**: 모델 선택기, Rules, Context

---

### 7. Settings (설정 관리)
**목적**: 사용자 선호도, 환경 설정, 동기화

**주요 기능**:
- 설정 UI
- 설정 동기화
- 키바인딩
- 테마
- 사용자 프로필

**핵심 도메인 모델**:
- `UserSettings`: 사용자 설정 애그리게이트 루트
- `EditorSettings`: 에디터 설정 (폰트, 탭 크기, etc.)
- `ThemeSettings`: 테마 설정 (LIGHT, DARK, HIGH_CONTRAST)

**서비스**:
- `UserSettingsService`: 사용자 설정 관리

**이벤트**:
- `UserSettingsCreatedEvent`
- `SettingsUpdatedEvent`
- `SettingsSyncEnabledEvent`

**Cursor 연관**: Settings 탭, Cursor Directory (.cursor)

---

### 8. Debugging (디버깅)
**목적**: 실행 흐름 추적, 변수 검사, 브레이크포인트

**주요 기능**:
- 브레이크포인트 (라인, 조건부, 예외, 데이터)
- 변수 감시
- 호출 스택
- 디버그 콘솔
- Step Over/Into/Out

**핵심 도메인 모델**:
- `DebugSession`: 디버그 세션 애그리게이트 루트
- `Breakpoint`: 브레이크포인트 엔티티
- `DebugStatus`: 디버그 상태 (INITIALIZED, RUNNING, PAUSED, STOPPED)

**서비스**:
- `DebugSessionService`: 디버그 세션 관리

**이벤트**:
- `DebugSessionStartedEvent`
- `DebugSessionRunningEvent`
- `DebugSessionPausedEvent`
- `DebugSessionStoppedEvent`
- `DebugStepEvent`

**Cursor 연관**: VS Code 기반 디버거 (Cursor도 지원)

---

### 9. Terminal & Build (터미널 및 빌드)
**목적**: 로컬 실행 환경 제공

**주요 기능**:
- 내장 터미널
- 태스크 실행
- 빌드 도구 통합
- 다양한 셸 지원 (BASH, ZSH, POWERSHELL, CMD, etc.)

**핵심 도메인 모델**:
- `TerminalSession`: 터미널 세션 애그리게이트 루트
- `BuildTask`: 빌드 작업 엔티티
- `ShellType`: 셸 유형

**서비스**:
- `TerminalSessionService`: 터미널 세션 관리

**이벤트**:
- `TerminalSessionCreatedEvent`
- `CommandExecutedEvent`
- `TerminalSessionClosedEvent`

**Cursor 연관**: 내장 터미널, Tasks

---

### 10. Collaboration (협업)
**목적**: 실시간 협업, 코드 리뷰, 공유 기능

**주요 기능**:
- 실시간 공동 편집
- 코드 리뷰
- 공유 세션
- 참가자 관리

**핵심 도메인 모델**:
- `CollaborationSession`: 협업 세션 애그리게이트 루트
- `CodeReview`: 코드 리뷰 엔티티
- `Participant`: 참가자 값 객체
- `ReviewComment`: 리뷰 코멘트

**서비스**:
- `CollaborationService`: 협업 세션 관리

**이벤트**:
- `CollaborationSessionCreatedEvent`
- `ParticipantJoinedEvent`
- `ParticipantLeftEvent`
- `CollaborativeEditEvent`
- `CollaborationSessionEndedEvent`

**Cursor 연관**: 현재는 미지원, 추후 예정 가능성

---

## 🎨 DDD 패턴 구조

각 바운디드 컨텍스트는 다음과 같은 일관된 구조를 따릅니다:

```
com/ide/{도메인명}/
├── command/
│   ├── domain/              # 도메인 레이어
│   │   ├── {Aggregate}.java      # 애그리게이트 루트
│   │   ├── {Entity}.java         # 엔티티
│   │   ├── {ValueObject}.java    # 값 객체
│   │   ├── {Event}.java          # 도메인 이벤트
│   │   └── {Repository}.java     # 리포지토리 인터페이스
│   └── application/         # 애플리케이션 레이어
│       ├── {Service}.java        # 애플리케이션 서비스
│       └── {Exception}.java      # 커스텀 예외
```

### DDD 핵심 원칙 적용

1. **애그리게이트 (Aggregate)**
   - 각 도메인의 루트 엔티티가 애그리게이트 루트 역할
   - 트랜잭션 일관성 경계 정의

2. **값 객체 (Value Object)**
   - 불변 객체로 구현
   - ID 값 객체 사용 (EditorId, WorkspaceId, etc.)

3. **도메인 이벤트 (Domain Event)**
   - 모든 중요한 도메인 변경사항을 이벤트로 발행
   - `Events.raise()` 메서드 사용

4. **리포지토리 (Repository)**
   - Spring Data JPA 인터페이스
   - 도메인 객체의 영속성 관리

5. **애플리케이션 서비스 (Application Service)**
   - 트랜잭션 관리
   - 도메인 객체 조정

---

## 🚀 기술 스택

- **Java**: JDK 8+
- **Spring Boot**: 애플리케이션 프레임워크
- **Spring Data JPA**: 영속성 관리
- **JPA/Hibernate**: ORM
- **MySQL**: 데이터베이스
- **Maven**: 빌드 도구

---

## 📊 주요 특징

### 1. 이벤트 기반 아키텍처
모든 도메인 변경사항은 이벤트로 발행되어 다른 바운디드 컨텍스트와 통신합니다.

### 2. 명확한 책임 분리
각 바운디드 컨텍스트는 독립적이고 명확한 책임을 가집니다.

### 3. 확장 가능한 구조
새로운 기능이나 도메인을 쉽게 추가할 수 있는 구조입니다.

### 4. 실제 IDE 기능 반영
Cursor와 같은 현대적인 IDE의 실제 기능들을 모델링했습니다.

---

## 💡 학습 포인트

이 프로젝트를 통해 다음을 학습할 수 있습니다:

1. **DDD 전략적 설계**
   - 바운디드 컨텍스트 식별
   - 도메인 분리 및 통합

2. **DDD 전술적 설계**
   - 애그리게이트 설계
   - 값 객체 활용
   - 도메인 이벤트 구현

3. **실무 적용**
   - 복잡한 도메인을 명확하게 모델링하는 방법
   - 이벤트 기반 아키텍처 구현

---

## 🎬 시작하기

### 데이터베이스 설정

1. MySQL 서버 실행
2. DDL 스크립트 실행:
```bash
mysql -u root -p < src/sql/ddl.sql
```

3. 초기 데이터 삽입:
```bash
mysql -u root -p < src/sql/init.sql
```

### 애플리케이션 실행

```bash
mvn spring-boot:run
```

또는

```bash
mvn clean package
java -jar target/ide-application.jar
```

애플리케이션은 `http://localhost:8080`에서 실행됩니다.

---

## 📖 참고 자료

- [도메인 주도 개발 시작하기](https://www.hanbit.co.kr/store/books/look.php?p_code=B4309942517) - DDD 기본 개념 학습
- [Cursor IDE](https://cursor.sh/) - 실제 IDE 참조
- Domain-Driven Design by Eric Evans - DDD 원론

---

## 🤝 기여

이 프로젝트는 학습 목적으로 만들어졌습니다. 개선 사항이나 제안이 있으시면 이슈를 등록해주세요.

---

## 📝 라이선스

이 프로젝트는 학습 및 교육 목적으로 제공됩니다.
