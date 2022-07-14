package config;

import org.aeonbits.owner.Config;


@Config.Sources("classpath:src/test/resources/config/credentials.properties")
public interface CredentialsConfig extends Config {


    String baseUrl();


    String login();


    String password();

    //  String remoteDriverUrl();

}