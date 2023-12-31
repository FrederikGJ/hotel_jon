package dk.lyngby.routes;

import dk.lyngby.controller.impl.RoomController;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.*;

public class RoomRoute {

    private final RoomController roomController = new RoomController();

    protected EndpointGroup getRoutes() {

        return () -> {
            path("/rooms", () -> {
                post("/hotel/{id}", roomController::create);
                get("/", roomController::readAll);
                get("/{id}", roomController::read);
                put("/{id}", roomController::update);
                delete("/{id}", roomController::delete);
            });
        };
    }
}
