@GetMapping("/employee/add")
public String addEmployeeForm(Model model) {
  model.addAttribute("employee", new Employee());
  return "employee_add.jte";
}

@PostMapping("/employee/add")
public String addEmployeeSubmit(@ModelAttribute Employee employee, RedirectAttributes ra) {
  Optional<Employee> existing = employeeRepo.findByFirstNameAndLastName(employee.getFirstName(), employee.getLastName());
  if (existing.isPresent()) {
    ra.addFlashAttribute("errorMessage", "Employee already exists: " + employee.getFirstName() + " " + employee.getLastName());
    return "redirect:/error/duplicate"; // or redirect to an error route
  }
  employeeRepo.save(employee);

  // Optionally create empty attendance rows for existing events.
  List<Event> events = eventRepo.findAll();
  for (Event ev : events) {
    Attendance a = new Attendance();
    a.setEmployee(employee);
    a.setEvent(ev);
    a.setAttended(null);
    attendanceRepo.save(a);
  }

  return "redirect:/";
}
