# TODOApp

A simple TODO application built with **Kotlin**, **Jetpack Compose**, **Room**, and **Hilt**, featuring task categories, date/time pickers, and notifications 10 minutes before a task is due.

---

## Screenshots
<img width="220" alt="image" src="https://github.com/user-attachments/assets/97ce3c65-f65a-4604-9622-bf8850ff8cc7" />
<img width="220" alt="image" src="https://github.com/user-attachments/assets/347eb5e2-55d7-40a4-abdf-0e8d8ffde118" />
<img width="220" alt="image" src="https://github.com/user-attachments/assets/23bc5906-5ef2-486b-894e-5556210c6fd6" />
<img width="220" alt="image" src="https://github.com/user-attachments/assets/2ac68704-da46-4940-8b0d-24d538572ced" />




## Features

- Add tasks with:
  - Title and description
  - Category (Work, Alarm, Travel, etc.)
  - Date and time
- Display tasks:
  - Today's tasks
  - Completed tasks
- Checkbox to mark tasks as done
- Notifications 10 minutes before a task
- Material3 components and modern Compose UI
- Dependency injection using Hilt

---

## Technologies Used

- Kotlin
- Jetpack Compose (Material3)
- Hilt for dependency injection
- Room for local database
- AlarmManager + BroadcastReceiver for notifications
- Coroutine `Flow` for reactive UI
