package lumbrera.reto.noelara.commons;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.logging.Logger;

@ApplicationScoped
public class InputStreamToStringParserImpl implements InputStreamToStringParser {

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    @Override
    public String inputStreamToString(final InputStream inputStream) {
        final StringBuilder crunchifyBuilder = new StringBuilder();
        try {
            final BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = in.readLine()) != null) {
                crunchifyBuilder.append(line.trim());
            }
        } catch (final Exception e) {
            LOGGER.error("Error Parsing: - ");
        }
        LOGGER.info(crunchifyBuilder.toString());

        return crunchifyBuilder.toString();
    }

}
