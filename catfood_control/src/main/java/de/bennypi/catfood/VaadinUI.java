package de.bennypi.catfood;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import de.bennypi.catfood.actuator_connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    private final Connector actuator;

    @Autowired
    public VaadinUI(Connector actuator) {
        this.actuator = actuator;
    }

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        setContent(content);
        content.addComponent(new Button("FOOD", this::notficationButton));
    }

    private void notficationButton(Button.ClickEvent event){
        if (actuator.deployFood()) {
        Notification.show("success");
        } else {
            Notification.show("error", Notification.Type.ERROR_MESSAGE);
        }
    }


}