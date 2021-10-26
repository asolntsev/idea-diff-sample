package andrei;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SomeServiceTest {
  private final String linux = "Hello\nLinux\nHello\nLinux\nHello\nLinux\n";
  private final String windows = "Hello\r\nLinux\r\nHello\r\nLinux\r\nHello\r\nLinux\r\n";

  @Test
  void diffShowsCRLF() {
    assertThat(linux).isEqualTo(windows);
  }

  @Test
  void diffHidesCRLF() {
    SomeService service = mock(SomeService.class);
    service.print(linux);
    verify(service).print(windows);
  }

  static class SomeService {
    public void print(String message) {
      System.out.println(message);
    }
  }
}