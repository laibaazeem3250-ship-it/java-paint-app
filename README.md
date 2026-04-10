# java-paint-app

> A fully functional Paint application built from scratch using 
> Java Swing & Graphics2D — inspired by Microsoft Paint.
> Made with ❤️ by Laiba Azeem
> *"Built during the most unexpected uni day ever 😄"*

---

## 📸 Screenshots

| View | Preview |
|------|---------|
| Paint App with Tools | ![Paint App](Paint_App.png) |

---

## ✨ Features

| Feature | Status |
|---------|--------|
| Freehand Brush Drawing | ✅ |
| Eraser Tool | ✅ |
| Line Drawing | ✅ |
| Rectangle Drawing | ✅ |
| Oval Drawing | ✅ |
| Color Picker | ✅ |
| Brush Size Slider | ✅ |
| Clear Canvas | ✅ |
| Save Drawing | ✅ |
| Multi-color Support | ✅ |
| Smooth Canvas Rendering | ✅ |

---

## 🧠 Concepts Applied

| Concept | How It's Used |
|---------|--------------|
| `enum ToolType` | Manages tool states cleanly |
| `CanvasPanel extends JPanel` | Custom drawing canvas |
| `BufferedImage` | Stores canvas pixel data |
| `Graphics2D` | Renders all shapes & drawings |
| `MouseListener` | Detects clicks & drags |
| `MouseAdapter` | Handles press & release events |
| `JSlider` | Controls brush size dynamically |
| `JComboBox` | Color selection dropdown |
| OOP Inheritance | CanvasPanel extends JPanel |

---

## 🎮 How to Use

| Tool | Action |
|------|--------|
| 🖌️ Brush | Click & drag to draw freely |
| 🧹 Eraser | Click & drag to erase |
| 📏 Line | Click & drag for straight lines |
| ⬜ Rectangle | Click & drag to draw rectangles |
| ⭕ Oval | Click & drag to draw ovals |
| 🎨 Color | Pick any color from dropdown |
| 📐 Size | Drag slider to change brush size |
| 🗑️ Clear | Wipes entire canvas clean |
| 💾 Save | Saves your drawing as image |

---

## 💡 App Architecture

PaintApp (JFrame)
├── Toolbar (JPanel)
│     ├── Brush Button
│     ├── Eraser Button
│     ├── Line Button
│     ├── Rectangle Button
│     ├── Oval Button
│     ├── Color Picker (JComboBox)
│     ├── Size Slider (JSlider)
│     ├── Clear Button
│     └── Save Button
└── CanvasPanel (JPanel)
├── BufferedImage (canvas)
├── Graphics2D (renderer)
├── MouseListener (input)
└── ToolType enum (state)

---

---

## 🚀 How to Run

1. Make sure **JDK 8+** is installed
2. Clone the repo:
```bash
   git clone https://github.com/laibaazeem3250-ship-it/java-paint-app.git
```
3. Open in **Eclipse IDE**
4. Run `PaintApp.java`
5. Start drawing! 🎨

---

## 📅 Progress Log

| Date | What I Built |
|------|-------------|
| April 10, 2026 | Full Paint App with 5 tools, color picker, size slider & save feature |

---

## 🛠️ Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![Graphics2D](https://img.shields.io/badge/Graphics2D-Canvas-green?style=for-the-badge)

---

## 🙋‍♀️ Author

**Laiba Azeem**
🎓 CS Student | Building real apps while still learning 💪
*Came to uni on the most uncertain day of the year 
and still shipped code 😄 — dedication level: MAX*

[![GitHub](https://img.shields.io/badge/GitHub-Follow-black?logo=github)](https://github.com/laibaazeem3250-ship-it)
