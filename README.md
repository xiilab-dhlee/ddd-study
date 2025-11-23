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

각 바운디드 컨텍스트는 **CQRS (Command Query Responsibility Segregation)** 패턴을 적용한 3-Layer 구조를 따릅니다:

```
com/ide/{도메인명}/
├── command/                 # 📝 Command (쓰기) - 상태 변경
│   ├── domain/              # 도메인 레이어
│   │   ├── {Aggregate}.java      # 애그리게이트 루트
│   │   ├── {Entity}.java         # 엔티티
│   │   ├── {ValueObject}.java    # 값 객체
│   │   ├── {Event}.java          # 도메인 이벤트
│   │   └── {Repository}.java     # 리포지토리 인터페이스
│   └── application/         # 애플리케이션 레이어
│       ├── {Service}.java        # 애플리케이션 서비스
│       └── {Exception}.java      # 커스텀 예외
├── query/                   # 🔍 Query (읽기) - 데이터 조회
│   ├── application/         # 조회 서비스
│   │   └── {QueryService}.java
│   ├── dao/                 # 데이터 접근 객체 (선택적)
│   │   └── {DataDao}.java
│   └── dto/                 # 데이터 전송 객체
│       └── {DTO}.java
└── infra/                   # 🔧 Infrastructure - 인프라 구현
    └── {EventHandler}.java  # 이벤트 핸들러
```

### 📊 CQRS 패턴 적용

#### Command (명령) - 쓰기 작업
- **목적**: 시스템의 상태를 **변경**
- **특징**:
  - 도메인 로직 실행
  - 트랜잭션 처리 (`@Transactional`)
  - 도메인 이벤트 발행
  - void 또는 ID 반환
- **예시**:
```java
@Service
public class AgentTaskService {
    @Transactional
    public AgentId createTask(AgentTaskType taskType, String description) {
        AgentId id = AgentId.generate();
        AgentTask task = new AgentTask(id, taskType, description, contextFiles);
        agentTaskRepository.save(task);
        return id;  // 생성된 ID만 반환
    }
}
```

#### Query (조회) - 읽기 작업
- **목적**: 데이터를 **조회만** 수행
- **특징**:
  - 상태를 변경하지 않음
  - 읽기 전용 트랜잭션 (`@Transactional(readOnly = true)`)
  - DTO로 데이터 반환
  - 성능 최적화에 집중
- **예시**:
```java
@Service
@Transactional(readOnly = true)
public class AgentTaskQueryService {
    public Optional<AgentTask> getTask(String agentId) {
        return agentTaskRepository.findById(new AgentId(agentId));
    }
    
    public List<AgentTask> getTasksByStatus(AgentTaskStatus status) {
        return agentTaskRepository.findByStatus(status);
    }
}
```

#### Infrastructure (인프라)
- **목적**: 기술적 관심사 처리
- **특징**:
  - 도메인 이벤트 처리
  - 로깅 및 모니터링
  - 외부 시스템 연동
  - 알림 발송
- **예시**:
```java
@Component
public class AgentEventHandler {
    private static final Logger logger = LoggerFactory.getLogger(AgentEventHandler.class);
    
    @EventListener
    public void handleTaskCompleted(AgentTaskCompletedEvent event) {
        logger.info("Agent task completed - ID: {}", event.getAgentId().getId());
        // 외부 시스템 알림, 메트릭 수집 등
    }
}
```

### DDD 핵심 원칙 적용

1. **애그리게이트 (Aggregate)**
   - 각 도메인의 루트 엔티티가 애그리게이트 루트 역할
   - 트랜잭션 일관성 경계 정의
   - 예: `Editor`, `AgentTask`, `Workspace`

2. **값 객체 (Value Object)**
   - 불변 객체로 구현
   - ID 값 객체 사용 (EditorId, WorkspaceId, etc.)
   - 도메인 개념 캡슐화 (TextContent, CursorPosition, etc.)

3. **도메인 이벤트 (Domain Event)**
   - 모든 중요한 도메인 변경사항을 이벤트로 발행
   - `Events.raise()` 메서드 사용
   - 느슨한 결합을 통한 도메인 간 통신

4. **리포지토리 (Repository)**
   - Spring Data JPA 인터페이스
   - 도메인 객체의 영속성 관리
   - Command 레이어에서 정의, Infra에서 구현

5. **애플리케이션 서비스 (Application Service)**
   - Command Service: 트랜잭션 관리, 도메인 객체 조정
   - Query Service: 읽기 전용 조회 작업

6. **CQRS 패턴**
   - Command와 Query의 명확한 분리
   - 각각 독립적으로 최적화 가능
   - 확장성과 유지보수성 향상

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
- 33개의 도메인 이벤트 정의
- 10개의 이벤트 핸들러로 느슨한 결합 구현
- Spring의 `@EventListener`를 활용한 비동기 처리 가능

### 2. CQRS 패턴 적용
Command(쓰기)와 Query(읽기)를 명확하게 분리하여 각각 최적화합니다.
- **Command**: 상태 변경, 도메인 로직, 이벤트 발행
- **Query**: 읽기 전용, DTO 반환, 성능 최적화
- **Infrastructure**: 이벤트 처리, 로깅, 외부 연동

### 3. 명확한 책임 분리
각 바운디드 컨텍스트는 독립적이고 명확한 책임을 가집니다.
- 10개의 바운디드 컨텍스트
- 각 도메인마다 Command, Query, Infra 레이어 분리
- 총 140+ Java 클래스로 구성

### 4. 확장 가능한 구조
새로운 기능이나 도메인을 쉽게 추가할 수 있는 구조입니다.
- 일관된 패키지 구조
- 표준화된 서비스 인터페이스
- 플러그인 가능한 이벤트 핸들러

### 5. 실제 IDE 기능 반영
Cursor와 같은 현대적인 IDE의 실제 기능들을 모델링했습니다.
- AI 기반 코드 생성 및 완성
- 실시간 협업 기능
- 확장 시스템

---

## 💡 학습 포인트

이 프로젝트를 통해 다음을 학습할 수 있습니다:

1. **DDD 전략적 설계**
   - 바운디드 컨텍스트 식별 (10개 도메인)
   - 도메인 분리 및 통합
   - 컨텍스트 맵핑

2. **DDD 전술적 설계**
   - 애그리게이트 설계 및 경계 설정
   - 값 객체 활용 (20+ 값 객체)
   - 도메인 이벤트 구현 (33개 이벤트)
   - 리포지토리 패턴

3. **CQRS 패턴**
   - Command와 Query의 분리
   - 읽기/쓰기 최적화 전략
   - DTO 활용 패턴

4. **이벤트 기반 아키텍처**
   - 도메인 이벤트 발행 및 처리
   - 이벤트 핸들러 구현
   - 느슨한 결합을 통한 확장성

5. **실무 적용**
   - 복잡한 도메인을 명확하게 모델링하는 방법
   - 대규모 프로젝트 구조화 전략
   - 계층형 아키텍처 설계

6. **Spring Framework 활용**
   - Spring Data JPA
   - Spring Event
   - Spring Transaction Management
   - Dependency Injection

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
