def countDownAndUp(number):
    print(number)
    # Base Case
    if number == 0:
        print('Reached the base case')
        return
    else:
        # Recursive case
        countDownAndUp(number - 1)
        print(number, 'returning')
        return

countDownAndUp(3)
