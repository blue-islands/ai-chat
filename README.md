# AIチャット

JavaでAIMLのプログラムを実行して、対話ができるようにするための備忘録

ライブラリはGoldRenardの[Program-JB](https://github.com/GoldRenard/Program-JB)を利用しています。

※ これはAIML2.0リファレンス実装です。AIMLは、チャットボットや、ALICE、Mitsuku、English Tutor、The Professor、SUPERなどのモバイル仮想アシスタントを作成するために広く採用されている標準です。

## 使い方

Mavenの利用ができます。
```xml
<repository>
    <id>jcenter</id>
    <name>jcenter-bintray</name>
    <url>http://jcenter.bintray.com</url>
</repository>

<dependency>
    <groupId>org.goldrenard</groupId>
    <artifactId>jb</artifactId>
    <version>VERSION</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>VERSION</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>VERSION</version>
</dependency>
```

## 日本語での実装方法
ベースは英語を対象に作られているため、日本語で利用するためには設定が必要になります。

```java
final var defaultResponse = "私にはその答えがありません。";
final var errorResponse = "私の脳に何か問題があります。";
final var scheduleError = "そのイベントをスケジュールできません。";
final var systemFailed = "システムコマンドの実行に失敗しました。";
final var templateFailed = "テンプレートが失敗しました。";
final var tooMuchRecursion = "AIMLの再帰が多すぎます。";
final var tooMuchLooping = "AIMLのループが多すぎます。";

final var language = LanguageConfiguration.builder()
        .defaultResponse(defaultResponse)
        .errorResponse(errorResponse)
        .scheduleError(scheduleError)
        .systemFailed(systemFailed)
        .templateFailed(templateFailed)
        .tooMuchRecursion(tooMuchRecursion)
        .tooMuchLooping(tooMuchLooping).build();

final var bot = new Bot(BotConfiguration.builder()
        .name("alice")
        .path("src/main/resources")
        .jpTokenize(true)
        .language(language)
        .build());

final var chatSession = new Chat(bot);

final var answer = chatSession.multisentenceRespond(text);
System.out.println(answer);
```

## AIML2.0リファレンス
https://note.com/npaka/n/n2c653844af74
