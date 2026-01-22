### `class HistoryBlock`
Используется в качестве блоков для истории в кошельке.

**Конструктор:** 
`HistoryBlock(int target_id, float value, String comment, String timestamp)`

**Параметры:**
- `target_id` — ID кошелька, которому направлялся перевод.
- `value` — сумма перевода.
- `comment` — комментарий к переводу.
- `timestamp` — время перевода.

**Методы:**
- `public String ToString()` — возвращает все данные о блоке в формате строки.

---

### `class Wallet`
Класс для кошельков.

**Приватные поля:** `money`, `id`, `History`.

**Публичные методы:**
- `GetID()` — получение ID кошелька.
- `GetMoney()` — получение средств кошелька.
- `ShowHistory()` — вывод всей истории кошелька.
- `SpendMoney()` — трата средств.

**Приватные методы:**
- `SetMoney(float value)` — установить значение поля `money`.
- `GetHistory()` — получить данные истории (возвращает `ArrayList`).
- `AddHistoryBlock(HistoryBlock block)` — добавить новую запись в историю.
- `SubMoney(float value)` — вычесть деньги.
  - **Ошибки:** `1` (недопустимое значение), `2` (недостаточно средств).
