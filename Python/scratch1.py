
a = 2
b = 3

def plex(command, num1, num2):

    commands = {"add": (num1 + num2),
                "subtract": (num1 - num2),
                "multiply": (num1 * num2),
                "divide": (num1 / num2)}

    if command not in commands:
        return "Not a valid command, choose one of the following:" + commands.keys().__repr__()

    else:
        return commands[command]

test_case1 = plex("foo", a, b)
assert test_case1 == "Not a valid command, choose one of the following:['multiply', 'add', 'subtract', 'divide']"

test_case2 = plex("add", a, b)
assert test_case2 == 5

test_case3 = plex("subtract",a,b)
assert test_case3 == -1

test_case4 = plex("multiply",a,b)
assert test_case4 == 6

test_case5 = plex("divide",a,b)
assert test_case5 == 0