package guru.qa.niffler.config;

public interface Config {

  static Config getInstance() {
    return LocalConfig.INSTANCE;
  }

  String frontUrl();

  String ghUrl();

  String gatewayUrl();

  String authUrl();

  String userdataUrl();

  String spendUrl();

  String currencyJdbcUrl();
  String spendJdbcUrl();
  String authJdbcUrl();
  String userdataJdbcUrl();
}
