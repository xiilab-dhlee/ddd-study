-- IDE 도메인 데이터베이스 생성
CREATE DATABASE idedb CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

CREATE USER 'ideuser'@'localhost' IDENTIFIED BY 'idepass';
CREATE USER 'ideuser'@'%' IDENTIFIED BY 'idepass';

GRANT ALL PRIVILEGES ON idedb.* TO 'ideuser'@'localhost';
GRANT ALL PRIVILEGES ON idedb.* TO 'ideuser'@'%';

USE idedb;

-- 1. Editor (편집기) 테이블
CREATE TABLE editor (
  editor_id VARCHAR(50) NOT NULL PRIMARY KEY,
  file_path VARCHAR(500),
  content MEDIUMTEXT,
  language VARCHAR(50),
  line_number INT,
  column_number INT,
  indent_size INT,
  use_tabs BOOLEAN,
  trim_trailing_whitespace BOOLEAN,
  syntax_highlighting_enabled BOOLEAN,
  code_folding_enabled BOOLEAN,
  minimap_enabled BOOLEAN,
  created_at DATETIME,
  last_modified_at DATETIME
) CHARACTER SET utf8mb4;

-- 2. Code Completion (코드 완성) 테이블
CREATE TABLE code_completion (
  completion_id VARCHAR(50) NOT NULL PRIMARY KEY,
  file_path VARCHAR(500),
  trigger_position INT,
  created_at DATETIME
) CHARACTER SET utf8mb4;

CREATE TABLE completion_items (
  completion_id VARCHAR(50) NOT NULL,
  label VARCHAR(200),
  insert_text TEXT,
  completion_type VARCHAR(50),
  documentation TEXT,
  confidence_score DOUBLE,
  FOREIGN KEY (completion_id) REFERENCES code_completion(completion_id)
) CHARACTER SET utf8mb4;

CREATE TABLE diagnostic (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  file_path VARCHAR(500),
  line_number INT,
  column_number INT,
  severity VARCHAR(20),
  message TEXT,
  error_code VARCHAR(50)
) CHARACTER SET utf8mb4;

-- 3. Workspace (워크스페이스) 테이블
CREATE TABLE workspace (
  workspace_id VARCHAR(50) NOT NULL PRIMARY KEY,
  name VARCHAR(200),
  root_path VARCHAR(500),
  git_enabled BOOLEAN,
  git_repository_url VARCHAR(500),
  created_at DATETIME,
  last_opened_at DATETIME
) CHARACTER SET utf8mb4;

CREATE TABLE workspace_folders (
  workspace_id VARCHAR(50) NOT NULL,
  folder_path VARCHAR(500),
  FOREIGN KEY (workspace_id) REFERENCES workspace(workspace_id)
) CHARACTER SET utf8mb4;

CREATE TABLE file_node (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200),
  path VARCHAR(500),
  type VARCHAR(20),
  parent_path VARCHAR(500),
  size BIGINT,
  created_at DATETIME,
  modified_at DATETIME
) CHARACTER SET utf8mb4;

-- 4. Agent Task (에이전트 작업) 테이블
CREATE TABLE agent_task (
  agent_id VARCHAR(50) NOT NULL PRIMARY KEY,
  task_type VARCHAR(50),
  description VARCHAR(2000),
  status VARCHAR(20),
  context_files VARCHAR(1000),
  result MEDIUMTEXT,
  created_at DATETIME,
  completed_at DATETIME
) CHARACTER SET utf8mb4;

-- 5. Extension (확장) 테이블
CREATE TABLE extension (
  extension_id VARCHAR(50) NOT NULL PRIMARY KEY,
  name VARCHAR(200),
  version VARCHAR(50),
  description VARCHAR(1000),
  publisher VARCHAR(100),
  status VARCHAR(20),
  download_count BIGINT,
  rating DOUBLE,
  install_path VARCHAR(500),
  installed_at DATETIME,
  published_at DATETIME
) CHARACTER SET utf8mb4;

-- 6. AI Model (AI 모델) 테이블
CREATE TABLE ai_model (
  model_id VARCHAR(50) NOT NULL PRIMARY KEY,
  name VARCHAR(200),
  provider VARCHAR(50),
  model_version VARCHAR(50),
  max_tokens INT,
  temperature DOUBLE,
  cost_per_token DOUBLE,
  is_active BOOLEAN,
  created_at DATETIME
) CHARACTER SET utf8mb4;

CREATE TABLE prompt_template (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200),
  template MEDIUMTEXT,
  purpose VARCHAR(50),
  max_context_files INT
) CHARACTER SET utf8mb4;

-- 7. User Settings (사용자 설정) 테이블
CREATE TABLE user_settings (
  settings_id VARCHAR(50) NOT NULL PRIMARY KEY,
  user_id VARCHAR(50),
  font_size INT,
  font_family VARCHAR(100),
  tab_size INT,
  insert_spaces BOOLEAN,
  word_wrap BOOLEAN,
  line_numbers BOOLEAN,
  auto_save BOOLEAN,
  theme VARCHAR(50),
  icon_theme VARCHAR(100),
  sync_enabled BOOLEAN,
  created_at DATETIME,
  updated_at DATETIME
) CHARACTER SET utf8mb4;

CREATE TABLE keybindings (
  settings_id VARCHAR(50) NOT NULL,
  command VARCHAR(200),
  keybinding VARCHAR(100),
  FOREIGN KEY (settings_id) REFERENCES user_settings(settings_id)
) CHARACTER SET utf8mb4;

-- 8. Debug Session (디버그 세션) 테이블
CREATE TABLE debug_session (
  session_id VARCHAR(50) NOT NULL PRIMARY KEY,
  program_path VARCHAR(500),
  status VARCHAR(20),
  current_line INT,
  current_file VARCHAR(500),
  started_at DATETIME,
  ended_at DATETIME
) CHARACTER SET utf8mb4;

CREATE TABLE breakpoint (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  session_id VARCHAR(50),
  file_path VARCHAR(500),
  line_number INT,
  condition TEXT,
  enabled BOOLEAN,
  type VARCHAR(20),
  FOREIGN KEY (session_id) REFERENCES debug_session(session_id)
) CHARACTER SET utf8mb4;

CREATE TABLE watched_variables (
  session_id VARCHAR(50) NOT NULL,
  variable_name VARCHAR(200),
  FOREIGN KEY (session_id) REFERENCES debug_session(session_id)
) CHARACTER SET utf8mb4;

-- 9. Terminal Session (터미널 세션) 테이블
CREATE TABLE terminal_session (
  terminal_session_id VARCHAR(50) NOT NULL PRIMARY KEY,
  name VARCHAR(200),
  working_directory VARCHAR(500),
  shell_type VARCHAR(50),
  is_active BOOLEAN,
  output_buffer MEDIUMTEXT,
  created_at DATETIME,
  last_command_at DATETIME
) CHARACTER SET utf8mb4;

CREATE TABLE build_task (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200),
  command VARCHAR(1000),
  type VARCHAR(50),
  working_directory VARCHAR(500),
  status VARCHAR(20),
  output MEDIUMTEXT,
  started_at DATETIME,
  completed_at DATETIME
) CHARACTER SET utf8mb4;

-- 10. Collaboration (협업) 테이블
CREATE TABLE collaboration_session (
  collaboration_session_id VARCHAR(50) NOT NULL PRIMARY KEY,
  session_name VARCHAR(200),
  host_user_id VARCHAR(50),
  shared_file_path VARCHAR(500),
  is_active BOOLEAN,
  max_participants INT,
  created_at DATETIME,
  ended_at DATETIME
) CHARACTER SET utf8mb4;

CREATE TABLE collaboration_participants (
  session_id VARCHAR(50) NOT NULL,
  user_id VARCHAR(50),
  user_name VARCHAR(100),
  role VARCHAR(20),
  FOREIGN KEY (session_id) REFERENCES collaboration_session(collaboration_session_id)
) CHARACTER SET utf8mb4;

CREATE TABLE code_review (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(200),
  file_path VARCHAR(500),
  author_id VARCHAR(50),
  reviewer_id VARCHAR(50),
  status VARCHAR(20),
  created_at DATETIME,
  completed_at DATETIME
) CHARACTER SET utf8mb4;

CREATE TABLE review_comments (
  review_id BIGINT NOT NULL,
  comment_text TEXT,
  line_number INT,
  commenter_id VARCHAR(50),
  created_at DATETIME,
  FOREIGN KEY (review_id) REFERENCES code_review(id)
) CHARACTER SET utf8mb4;

-- 이벤트 저장소 테이블
CREATE TABLE evententry (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `type` VARCHAR(255),
  `content_type` VARCHAR(255),
  payload MEDIUMTEXT,
  `timestamp` DATETIME
) CHARACTER SET utf8mb4;
