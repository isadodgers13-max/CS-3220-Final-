@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

  @RequestMapping("/error")
  public String handleError(HttpServletRequest request, Model model) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    Integer statusCode = status == null ? 500 : Integer.valueOf(status.toString());
    model.addAttribute("statusCode", statusCode);
    model.addAttribute("message", request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
    return "error.jte";
  }

  @GetMapping("/error/duplicate")
  public String duplicateError(@ModelAttribute("errorMessage") String errorMessage, Model model) {
    model.addAttribute("message", errorMessage);
    return "error.jte";
  }
}
