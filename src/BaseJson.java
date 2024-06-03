import java.util.Map;

public record BaseJson(
        String result,
        String base_code,
        Map<String, Double>conversion_rates

        ) {
}