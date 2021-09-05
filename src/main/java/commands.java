import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class commands extends ListenerAdapter {

    String prefix = "#";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" "); // input: $help 1, args[0] = $help, args[1] = 1
        MessageChannel channel = event.getChannel();

        if(args[0].equalsIgnoreCase(prefix+"ping")){
            long time = System.currentTimeMillis();
            channel.sendMessage("퐁!") /* => RestAction<Message> */
                    .queue(response /* => Message */ -> {
                        response.editMessageFormat("응답시간: %d ms", System.currentTimeMillis() - time).queue();
                    });
        }
    }
}
