package by.htp.cratemynewpc.controller;


import by.htp.cratemynewpc.controller.CommandName;
import by.htp.cratemynewpc.controller.command.Command;
import by.htp.cratemynewpc.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

class CommandProvider {

    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.MAIN_PAGE, new MainPage());
        commands.put(CommandName.REG_PAGE, new RegPage());
        commands.put(CommandName.SIGN_IN, new SignIn());
        commands.put(CommandName.LOCALIZATION, new Localization());
        commands.put(CommandName.REGISTRATION, new Rigistration());
        commands.put(CommandName.SING_OUT, new SignOut());
        commands.put(CommandName.DELETE_USER_PC, new DeleteUserPC());
    }

    Command getCommand(String commandName) {
        Command command;

        command = commands.get(CommandName.valueOf(commandName.toUpperCase()));

        return command;

    }

}
