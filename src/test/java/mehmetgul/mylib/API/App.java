package mehmetgul.mylib.API;

import spark.Request;
import spark.Response;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.format;
import static spark.Spark.*;


/**
 * https://rapidapi.com/ good for samples
 */
public class App {
	private static final Map<String, Map<String, Map<String, String>>> cache = new ConcurrentHashMap<>();
	public static void main(String[] args) {
		cache.put("GET", new ConcurrentHashMap<>());
		cache.put("POST", new ConcurrentHashMap<>());
		cache.put("PUT", new ConcurrentHashMap<>());
		cache.put("DELETE", new ConcurrentHashMap<>());
		patch("/setup", "application/json", (request, response) -> {
			System.out.println(request);
			Map<String, String> mockedResponse = new ConcurrentHashMap<>();
			mockedResponse.put("status", request.queryParams("status"));
			request.headers()
					.stream()
					.filter(h -> !h.equals("status"))
					.forEach(h -> mockedResponse.put("header:" + h, request.headers(h))
					);
			mockedResponse.put("body", request.body());
			cache.get(request.queryParams("method"))
					.put(request.queryParams("endpoint"), mockedResponse);
			return format("mock response for %s set to status: %s\n\n and payload: %s",
					request.queryParams("endpoint"), mockedResponse.get("status"), mockedResponse.get("body"));
		});
		get("*", "*/*", (request, response) -> {
			setupMockResponse(request, response);
			return response.body();
		});
		post("*", "*/*", (request, response) -> {
			setupMockResponse(request, response);
			return response.body();
		});
		put("*", "*/*", (request, response) -> {
			setupMockResponse(request, response);
			return response.body();
		});
		delete("*", "*/*", (request, response) -> {
			setupMockResponse(request, response);
			return response.body();
		});
	}
	private static void setupMockResponse(Request request, Response response) {
		Map<String, String> mockedResponse = cache.get(request.requestMethod()).get(request.uri());
		response.status(Integer.valueOf(mockedResponse.get("status")));
		mockedResponse.keySet()
				.stream()
				.filter(k -> k.startsWith("header:"))
				.forEach(k ->
						response.header(k.replace("header:", ""), mockedResponse.get(k))
				);
		response.body(mockedResponse.get("body"));
	}
}