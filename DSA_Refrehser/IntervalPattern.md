# Interval Problems – Complete Pattern Guide

## 🧠 1. Core Types of Interval Problems

### Type A: Merge / Union Intervals

Goal:

```text
Combine overlapping intervals
```

Pattern:

* Sort by start
* Merge greedily OR sweep line

Key idea:

```text
If overlap → extend interval
Else → start new interval
```

---

### Type B: Overlap Detection (Line Sweep)

Goal:

```text
Check if intervals overlap at any time
```

Pattern:

* Convert intervals → events
* +1 for start, -1 for end
* Track active count

Use cases:

* Can attend meetings
* Maximum overlap
* Timeline simulation

---

### Type C: Interval Scheduling (Greedy Optimization)

Goal:

```text
Maximize non-overlapping intervals
OR minimize removals
```

Pattern:

* Sort by END time
* Always pick earliest finishing interval

Key idea:

```text
Greedy by finish time
```

Use cases:

* Erase Overlap Intervals
* Activity selection problem

---

## ⚖️ 2. When to use what?

| Problem Type    | Approach             |
| --------------- | -------------------- |
| Merge intervals | Sort + Merge         |
| Overlap count   | Line Sweep           |
| Max non-overlap | Greedy (end sorting) |

---

## 🚨 3. Critical Interview Insight

### Line Sweep is NOT for optimization

Line sweep answers:

```text
“How many intervals overlap?”
```

Greedy answers:

```text
“Which intervals should I keep/remove?”
```

---

## 🧩 4. Common Mistakes

❌ Using line sweep for erase overlap
❌ Using overlap count to decide removals
❌ Ignoring interval ordering importance

---

## 🔥 5. Mental Shortcut

```text
If problem says:
→ merge / union → sorting + merging

→ count overlap → line sweep

→ minimize removals → greedy by end
```

---

## 🧠 6. One-line Memory Rule

```text
Start-based thinking → Merge / Sweep
End-based thinking → Greedy optimization
```
