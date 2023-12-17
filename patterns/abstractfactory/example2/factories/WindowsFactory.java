package patterns.abstractfactory.example2.factories;

import patterns.abstractfactory.example2.buttons.Button;
import patterns.abstractfactory.example2.buttons.WindowsButton;
import patterns.abstractfactory.example2.checkboxes.Checkbox;
import patterns.abstractfactory.example2.checkboxes.WindowsCheckbox;

public class WindowsFactory extends GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
