package patterns.abstractfactory.example2.factories;

import patterns.abstractfactory.example2.buttons.Button;
import patterns.abstractfactory.example2.buttons.MacOSButton;
import patterns.abstractfactory.example2.checkboxes.Checkbox;
import patterns.abstractfactory.example2.checkboxes.MacOSCheckbox;

public class MacOSFactory extends GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
