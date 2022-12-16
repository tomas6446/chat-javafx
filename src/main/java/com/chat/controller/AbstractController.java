package com.chat.controller;

import com.chat.server.Client;
import com.chat.view.ViewHandler;
import javafx.fxml.Initializable;

/**
 * @author Tomas Kozakas
 */
public abstract class AbstractController implements Initializable {
    protected final ViewHandler viewHandler;

    protected AbstractController(ViewHandler viewHandler, Client client) {
        this.viewHandler = viewHandler;
    }
}
