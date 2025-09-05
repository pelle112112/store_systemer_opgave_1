module soft2.bootapp {
    requires soft2.user;
    requires soft2.marketing;
    requires soft2.social;
    requires soft2.media;
    requires io.javalin;

    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;

    opens soft2.bootapp to com.fasterxml.jackson.databind;
}