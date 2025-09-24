# TorneoFutbol – 16-Team Championship ⚽

Java academic project (Universidad Icesi) that manages an **international football tournament** with 16 clubs, including **group stage, knockout brackets (QF/SF/Final), referees assignment, player eligibility, match events, and KPIs**. Built with **OOP** (inheritance, polymorphism, interfaces), **2D matrices** and **dynamic containers**, plus **UML** and **JavaDoc**.

---

## ✨ Features

### Registration
- Teams (name, country, 20-player roster, head coach, assistant coach)
- Players (number, name, country, position: GK/DF/MF/FW)
- Referees (id, name, country, type: Center/Assistant) – store **8 centers** and **16 assistants**

### Fixture & Rounds
- Random draw: **16 teams → 4 groups (A–D)**, 4 teams each
- Group stage: each team plays **3** matches (single round-robin)
- Constraints:
  - **Interleaved** matchdays across groups
  - **≥ 2 days rest** between matches per team
  - **Last group matchday**: both matches at the **same time**
- Knockouts: **Quarterfinals → Semifinals → Final**
  - QF pairing: A1–B2, A2–B1, C1–D2, C2–D1

### Referees Assignment
- Each match: **1 Center + 2 Assistants**
- **Nationality constraint:** referees’ nationality **≠** both teams’ countries

### Match Management
- Pre-match: select **XI starters** (eligible players only)
- In-match: up to **3 substitutions**
- Post-match: record **score**, **goal scorers** and **assisters**, and **cards**
  - **2 yellow cards across different matches ⇒ next-match ban (groups only)**
  - **Red cards** from last group match carry into QF

### Standings & Tie-breakers
- Table columns: MP, W, D, L, GF, GA, GD, Pts
- Ranking: **Pts → GD → GF → GA**

### KPIs
- Team **win rate** = wins / matches played
- Player **scoring efficiency** = goals / matches played
- Center referee **card index** = cards shown / matches refereed

---

## 🧱 Architecture & Data Structures
- **OOP** with inheritance, interfaces and polymorphism
- **2D matrices** for group standings
- **Dynamic containers** (lists) for squads, schedule and referees
- Separation **UI (console)** vs **Model**
- **UML diagrams** and **JavaDoc**

---

## 📂 Project Structure
TorneoFutbol/
├── src/
│ ├── ui/ # Console UI (menus, prompts)
│ └── model/ # Core domain: Team, Player, Referee, Match, Group, Tournament, etc.
├── bin/ # Compiled .class files
├── doc/
│ ├── UML/ # Class diagrams, design docs (EN)
│ └── API/ # Generated JavaDoc
├── .gitignore
└── README.md


---

## 🚀 How to Run

1) **Compile**

bash

javac -d bin src/model/*.java src/ui/*.java


Run

java -cp bin ui.Main


Ensure your Main class is in ui package and uses the model services.

🧪 JavaDoc

Generate documentation into doc/API/:

javadoc -d doc/API src/model/*.java src/ui/*.java

🗺️ Roadmap

 Persistency layer (files/DB)

 Web UI (responsive, <2s, 99.9% availability target)

 More constraints (stadiums, time slots)

 Automated tests

👤 Author

Juan — Universidad Icesi — 🇨🇴
GitHub: https://github.com/Pipe0318
