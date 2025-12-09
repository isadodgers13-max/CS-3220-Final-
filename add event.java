@GetMapping("/event/add")
public String addEventForm(Model model) {
  model.addAttribute("event", new Event());
  return "event_add.jte";
}

@PostMapping("/event/add")
public String addEventSubmit(@ModelAttribute Event event) {
  Event saved = eventRepo.save(event);

  // Optionally create attendance rows for all existing employees
  List<Employee> employees = employeeRepo.findAll();
  for (Employee e : employees) {
    Attendance a = new Attendance();
    a.setEvent(saved);
    a.setEmployee(e);
    a.setAttended(null);
    attendanceRepo.save(a);
  }

  return "redirect:/";
}
