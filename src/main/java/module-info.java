module org.example.javafxhibernate {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires mysql.connector.j;
    requires java.sql;
    requires java.naming;
    requires static lombok;

    opens org.example.javafxhibernate to javafx.fxml;
    exports org.example.javafxhibernate;

    exports org.example.javafxhibernate.models;
    opens org.example.javafxhibernate.models to org.hibernate.orm.core, javafx.base;
}