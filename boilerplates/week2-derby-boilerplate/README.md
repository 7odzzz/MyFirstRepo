# Week 2 — JDBC with Embedded Derby (Ready-to-Run)

Pre-configured Java project with Apache Derby embedded.  
**No MySQL, no server setup, no extra downloads needed.**

## How to Open

### Eclipse

1. File → Import → General → Existing Projects into Workspace
2. Select this folder → Finish
3. Right-click `Main.java` → Run As → Java Application

### IntelliJ IDEA

1. File → Open → select this folder
2. Wait for indexing to finish
3. Open `src/Main.java` → click ▶ next to `main()`

### VS Code

1. Open this folder in VS Code
2. Install "Extension Pack for Java" if prompted
3. Open `src/Main.java` → click **Run** above `main()`

### NetBeans

1. File → Open Project (or Import → Java Project with Existing Sources)
2. Set `src` as the source folder
3. Add all jars from `libs/` to project Libraries
4. Right-click `Main.java` → Run File

## Project Structure

```
week2-derby-boilerplate/
├── libs/               ← Derby jars (already included)
│   ├── derby.jar
│   ├── derbyshared.jar
│   └── derbytools.jar
├── src/
│   └── Main.java       ← Run this — your work goes here
├── .classpath           ← Eclipse config
├── .project             ← Eclipse config
├── .idea/               ← IntelliJ config
└── .vscode/             ← VS Code config
```

## What Happens When You Run

1. Derby creates an embedded database in `./db/AAST`
2. A `Users` table is created
3. A sample user is inserted and queried
4. Output prints to console — no external DB required!

## Notes

- The `db/` folder is created at runtime — delete it to start with a fresh database.
- Derby 10.16.1.1 works with Java 17+.
- All JARs are bundled — no internet needed after download.
