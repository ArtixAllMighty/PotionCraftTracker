package tracker.commands;

import tracker.PotionTracker;
import tracker.Potions;

import java.util.List;
import java.util.stream.Collectors;

public class CommandFix extends Command {

    public CommandFix() {
        super("fix");
    }

    @Override
    public void execute() {
        if (getArgument().length() == 0)
            throw new IllegalArgumentException("cannot execute command. not enough data");
        List<Potions> potions = Potions.getPotionsFromString(getArgument());
        if (!potions.isEmpty() && PotionTracker.tracker.containsKey(potions)) {
            int total = PotionTracker.tracker.get(potions);
            PotionTracker.tracker.put(potions, --total);
            System.out.format("Successfully removed 1 counter for %s", potions.stream().map(Enum::name).collect(Collectors.joining()));
        }
    }
}
