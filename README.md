## Dashboard

新版的 Dashboard 專案，包含：

1. dashboard: Playframework 網站
    * 視覺化圖表
    * 營運管理數據整合
    * 帳號權限控管
2. batch-task: 批次排程程式，統計各資料源
    * GA
    * 營收
3. common: dashboard, batch-task 共用程式
    * DateTimeUtils: 處理時間格式
    * DBUtils: JDBC 常用函式
    * MailUtils: 寄信程式


專案目錄
* 根目錄： dashboard 專案
* batch-task: 批次排程程式
* common: 共用程式

除 sbt 自定的目錄外，
* doc: 放系統文件，如 table schema 設計。系統 deployment 流程等，請用純文字格式撰寫(如: markdown, table schema 請寫 sql 指令)，以利 git 做版本控制

## 環境定義
* 開發測試環境
    * 測試資料源
    * 測試資料庫
    * 測試人員 email
* 準正式環境
    * 正式資料源
    * 測試資料庫
    * 測試人員 email
* 正式環境
    * 正式資料源
    * 正式資料庫
    * 正式人員 email

## dashboard (root)

環境設定檔
* `conf/application.conf`: 開發測試環境設定檔
* `conf/pre-prod.conf`: 準正式環境設定檔
* `conf/prod.conf`: 正式環境設定檔

Logger 設定檔
* `conf/logback.xml`: 開發測試環境設定檔
* `conf/pre-prod-logger.xml`: 準正式環境設定檔
* `conf/prod-logger.xml`: 正式環境設定檔

### 打包與執行
打包指令： `dist`。在打包程式前，請都先執行 `clean`。

執行
* 測試版本：`/path/to/bin/<project-name>`
* 準正式環境版本：`/path/to/bin/<project-name> -Dconfig.resource=pre-prod.conf -Dlogger.resource=conf/pre-prod-logger.xml`
* 正式環境版本：`/path/to/bin/<project-name> -Dconfig.resource=prod.conf -Dlogger.resource=conf/prod-logger.xml`


## batch-task
設定檔目錄
* `src/main/resources`: 開發測試環境設定檔
* `src/pre-prod/resources`: 準正式環境設定檔
* `src/prod/resources`: 正式環境設定檔

### Assembly

在打包程式前，請都先執行 `clean`

* 測試版本：`assembly`
* 準正式環境版本：`pre-prod:assembly`
* 正式環境版本：`prod:assembly`

**本文件請依專案開發過程，隨時更新。**