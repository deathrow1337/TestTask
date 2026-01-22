### class HistoryBlock
  Используется в качестве блоков для истории в кошельке.
  HistoryBlock(int target_id, float value, String comment, String timestamp)
    > target_id - ID кошелька, кому направлялся перевод
    > value - Сумма перевода
    > comment - Комментарий к переводу
    > timestamp - Время перевода
  public String ToString() -> Возвращает все данные о блоке в формате строки

### class Wallet 
  Класс для кошельков.
  Поля (все приватные): money, id, History
  Публичные методы:
    GetID() -> Получение ID кошелька
    GetMoney() -> Получение средств кошелька.
    ShowHistory() -> Вывод всей истории кошелька (Список Wallet.History)
    SpendMoney() -> Трата средств с кошелька
  Приватные методы:
    SetMoney(float value) -> Установить значение поля money
    GetHistory() -> Получить "сырые" данные истории трат
      > Возвращает ArrayList<HistoryBlock>
    AddHistoryBlock(HistoryBlock block) -> Добавить новую запись в историю
    SubMoney(float value) -> Вычесть деньги
      > Имеет 2 кода ошибки ( 1 - Недопустимое значение, 2 - Недостаточно средств )
    
