package com.spring_asynchronous;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class GitHubLookupService {

  private final RestTemplate restTemplate;

  public GitHubLookupService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Async
  public CompletableFuture<User> findUser(String user) throws InterruptedException {
    log.info("looking up > {}", user);
    String url = String.format("https://api.github.com/users/%s", user);
    User response = restTemplate.getForObject(url, User.class);
    Thread.sleep(1000L);
    return CompletableFuture.completedFuture(response);
  }
}
