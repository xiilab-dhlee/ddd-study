USE idedb;

-- 테이블 초기화
TRUNCATE TABLE editor;
TRUNCATE TABLE code_completion;
TRUNCATE TABLE completion_items;
TRUNCATE TABLE diagnostic;
TRUNCATE TABLE workspace;
TRUNCATE TABLE workspace_folders;
TRUNCATE TABLE file_node;
TRUNCATE TABLE agent_task;
TRUNCATE TABLE extension;
TRUNCATE TABLE ai_model;
TRUNCATE TABLE prompt_template;
TRUNCATE TABLE user_settings;
TRUNCATE TABLE keybindings;
TRUNCATE TABLE debug_session;
TRUNCATE TABLE breakpoint;
TRUNCATE TABLE watched_variables;
TRUNCATE TABLE terminal_session;
TRUNCATE TABLE build_task;
TRUNCATE TABLE collaboration_session;
TRUNCATE TABLE collaboration_participants;
TRUNCATE TABLE code_review;
TRUNCATE TABLE review_comments;
TRUNCATE TABLE evententry;

-- 샘플 데이터 삽입

-- 1. Editor 샘플 데이터
INSERT INTO editor (editor_id, file_path, content, language, line_number, column_number, 
                   indent_size, use_tabs, trim_trailing_whitespace,
                   syntax_highlighting_enabled, code_folding_enabled, minimap_enabled,
                   created_at, last_modified_at)
VALUES ('editor-001', '/workspace/src/Main.java', 
        'public class Main {\n    public static void main(String[] args) {\n        System.out.println("Hello IDE");\n    }\n}',
        'JAVA', 0, 0, 4, FALSE, TRUE, TRUE, TRUE, TRUE, NOW(), NOW());

-- 2. Workspace 샘플 데이터
INSERT INTO workspace (workspace_id, name, root_path, git_enabled, git_repository_url, 
                      created_at, last_opened_at)
VALUES ('ws-001', 'IDE Project', '/workspace/ide-project', TRUE, 
        'https://github.com/example/ide-project.git', NOW(), NOW());

INSERT INTO workspace_folders (workspace_id, folder_path)
VALUES ('ws-001', '/workspace/ide-project/src'),
       ('ws-001', '/workspace/ide-project/test');

-- 3. Extensions 샘플 데이터
INSERT INTO extension (extension_id, name, version, description, publisher, status, 
                      download_count, rating, published_at)
VALUES ('ext-001', 'Java Language Support', '1.0.0', 
        'Provides Java language support', 'Microsoft', 'AVAILABLE', 1000000, 4.5, NOW()),
       ('ext-002', 'Python Extension', '2.0.0', 
        'Python language support and debugging', 'Microsoft', 'AVAILABLE', 2000000, 4.8, NOW()),
       ('ext-003', 'GitLens', '12.0.0', 
        'Supercharge Git capabilities', 'GitKraken', 'AVAILABLE', 5000000, 4.9, NOW());

-- 4. AI Models 샘플 데이터
INSERT INTO ai_model (model_id, name, provider, model_version, max_tokens, temperature, 
                     cost_per_token, is_active, created_at)
VALUES ('model-001', 'GPT-4o', 'OPENAI', '2024-05-13', 128000, 0.7, 0.00001, TRUE, NOW()),
       ('model-002', 'Claude 3.5 Sonnet', 'ANTHROPIC', '20241022', 200000, 0.7, 0.000015, TRUE, NOW()),
       ('model-003', 'Gemini Pro', 'GOOGLE', '1.5', 2000000, 0.7, 0.000002, TRUE, NOW());

-- 5. Prompt Templates 샘플 데이터
INSERT INTO prompt_template (name, template, purpose, max_context_files)
VALUES ('Code Generation', 
        'Generate {0} code for the following requirement:\n{1}\n\nContext files:\n{2}',
        'CODE_GENERATION', 5),
       ('Bug Fix', 
        'Fix the following bug in {0}:\n{1}\n\nCode:\n{2}',
        'BUG_FIX', 3),
       ('Code Review', 
        'Review the following code and provide suggestions:\n{0}',
        'CODE_REVIEW', 1);

-- 6. User Settings 샘플 데이터
INSERT INTO user_settings (settings_id, user_id, font_size, font_family, tab_size, 
                          insert_spaces, word_wrap, line_numbers, auto_save, 
                          theme, icon_theme, sync_enabled, created_at, updated_at)
VALUES ('settings-001', 'user1', 14, 'Consolas', 4, TRUE, FALSE, TRUE, TRUE, 
        'DARK', 'default', TRUE, NOW(), NOW()),
       ('settings-002', 'user2', 16, 'Monaco', 2, TRUE, TRUE, TRUE, FALSE, 
        'LIGHT', 'material', FALSE, NOW(), NOW());

-- 7. Terminal Session 샘플 데이터
INSERT INTO terminal_session (terminal_session_id, name, working_directory, shell_type, 
                              is_active, output_buffer, created_at)
VALUES ('term-001', 'Terminal 1', '/workspace', 'BASH', TRUE, 
        '$ ls\nsrc  test  README.md\n$ ', NOW());

-- 8. Build Tasks 샘플 데이터
INSERT INTO build_task (name, command, type, working_directory, status)
VALUES ('Maven Build', 'mvn clean install', 'BUILD', '/workspace', 'PENDING'),
       ('Run Tests', 'mvn test', 'TEST', '/workspace', 'PENDING'),
       ('Run Application', 'java -jar target/app.jar', 'RUN', '/workspace', 'PENDING');

-- 9. File Nodes 샘플 데이터
INSERT INTO file_node (name, path, type, parent_path, size, created_at, modified_at)
VALUES ('src', '/workspace/src', 'DIRECTORY', '/workspace', 0, NOW(), NOW()),
       ('Main.java', '/workspace/src/Main.java', 'FILE', '/workspace/src', 256, NOW(), NOW()),
       ('test', '/workspace/test', 'DIRECTORY', '/workspace', 0, NOW(), NOW()),
       ('README.md', '/workspace/README.md', 'FILE', '/workspace', 1024, NOW(), NOW());
