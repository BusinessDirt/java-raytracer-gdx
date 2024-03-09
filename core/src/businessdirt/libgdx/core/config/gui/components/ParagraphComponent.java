package businessdirt.libgdx.core.config.gui.components;

import businessdirt.libgdx.core.config.data.PropertyData;
import businessdirt.libgdx.core.config.gui.components.extras.GuiComponent;
import businessdirt.libgdx.core.util.Config;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class ParagraphComponent extends TextField implements GuiComponent {

    public ParagraphComponent(PropertyData property, Skin skin, float width, float height) {
        super(property.getAsString(), skin);
        this.setSize(GuiComponent.width, GuiComponent.height);
        this.setPosition(width - 50f * scale - (GuiComponent.width + this.getWidth() * this.getScaleX()) / 2, height - this.getHeight() * this.getScaleY() / 2 - height / 2);
        this.setTextFieldFilter((textField, c) -> Character.toString(c).matches("[a-zA-Z]"));
        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                property.setValue(getText());
                Config.getConfig().writeData();
            }
        });
    }
}
