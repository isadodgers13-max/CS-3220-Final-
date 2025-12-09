@GetMapping("/")
public String index(Model model) {
  List<Event> events = eventRepo.findAllByOrderByIdAsc();
  List<Employee> employees = employeeRepo.findAllByOrderByLastNameAscFirstNameAsc();

  // fetch all attendance to avoid N+1
  List<Attendance> all = attendanceRepo.findAll();
  Map<Long, Map<Long, Attendance>> map = new HashMap<>();
  for (Attendance a : all) {
    map.computeIfAbsent(a.getEmployee().getId(), k->new HashMap<>()).put(a.getEvent().getId(), a);
  }

  model.addAttribute("events", events);
  model.addAttribute("employees", employees);
  model.addAttribute("attendanceMap", map);

  return "index.jte"; // JTE template
}
