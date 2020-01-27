package lumbrera.reto.noelara.commons;

import java.io.InputStream;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface InputStreamToStringParser {

    public String inputStreamToString(InputStream inputStream);
}
