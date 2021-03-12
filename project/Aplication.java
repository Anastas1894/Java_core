package project;

import project.view.IUserInterface;
import project.view.UserInterface;

public class Aplication {
    public static void main(String[] args) {
        IUserInterface ui = new UserInterface();
        ui.showMenu();
    }
}
