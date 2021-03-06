import java.util.Scanner;

import org.goldrenard.jb.configuration.BotConfiguration;
import org.goldrenard.jb.configuration.LanguageConfiguration;
import org.goldrenard.jb.core.Bot;
import org.goldrenard.jb.core.Chat;

public class Test {

    public static void main(String[] args) {

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

        final var scanner = new Scanner(System.in); // Scannerで初期化

        while (true) {
            System.out.println("私:何か話しかけてね。");
            final var text = scanner.next(); // 文字列の入力の受け取り
            System.out.println("貴方:" + text);
            if (text.contains("バイバイ")) {
                scanner.close();
                return;
            }

            final var answer = chatSession.multisentenceRespond(text);
            System.out.println("私:" + answer);
        }

    }

}
