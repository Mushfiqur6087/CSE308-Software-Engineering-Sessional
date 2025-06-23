package patterns.abstractfactory.example2.factories;


import patterns.abstractfactory.example2.buttons.Button;
import patterns.abstractfactory.example2.checkboxes.Checkbox;

public abstract class GUIFactory {
    public abstract Button createButton();
    public abstract Checkbox createCheckbox();
}