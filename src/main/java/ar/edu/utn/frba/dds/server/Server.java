package ar.edu.utn.frba.dds.server;

import ar.edu.utn.frba.dds.scripts.Bootstrap;
import ar.edu.utn.frba.dds.server.templates.JavalinHandlebars;
import ar.edu.utn.frba.dds.server.templates.JavalinRenderer;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.http.staticfiles.Location;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Server {
  public void start() {

    try {
      Files.createDirectories(Paths.get("uploads"));
    } catch (IOException e) {
      throw new RuntimeException("No se pudo crear la carpeta uploads", e);
    }

    var app = Javalin.create(config -> {
      initializeStaticFiles(config);
      initializeTemplating(config);
    });

    new Router().configure(app);

    int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "9001"));
    app.start("0.0.0.0", port);
//    app.start(9001);
  }

  private void initializeTemplating(JavalinConfig config) {
    config.fileRenderer(
      new JavalinRenderer().register("hbs", new JavalinHandlebars())
    );
  }

  private static void initializeStaticFiles(JavalinConfig config) {
    config.staticFiles.add(staticFileConfig -> {
      staticFileConfig.hostedPath = "/assets";
      staticFileConfig.directory = "assets";
      staticFileConfig.location = Location.CLASSPATH;
      staticFileConfig.precompress = false;
    });

    config.staticFiles.add(staticFileConfig -> {
      staticFileConfig.hostedPath = "/images";
      staticFileConfig.directory = "images";
      staticFileConfig.location = Location.CLASSPATH;
      staticFileConfig.precompress = false;
    });

    config.staticFiles.add(staticFiles -> {
      staticFiles.hostedPath = "/uploads";
      staticFiles.directory = "uploads";
      staticFiles.location = Location.EXTERNAL;
    });
  }
}
