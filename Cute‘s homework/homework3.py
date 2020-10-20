def move(location, action):
    '''Function here is to update the new location when after action
    location is a tuple representing every location of vehicle in the process
    action is a string of every single action
    return new location'''
    # Build the dictionaries.
    # Key of dictionary is direction of the vehicle.
    # Value of dictionary is changed part of location after action.
    drive_dict = {'E': 1, 'W': - 1,
                  'N':   1, 'S': - 1}
    turnl_dict = {'E': 'N', 'N': 'W', 'W': 'S', 'S': 'E'}
    turnr_dict = {'E': 'S', 'S': 'W', 'W': 'N', 'N': 'E'}
    direction = location[2]
    # Find the new location after every single action.
    if action == 'Drive':
        if direction == 'E' or direction == 'W':
            location = (location[0]+drive_dict[direction], location[1], location[2])
        else:
            location = (location[0], location[1]+drive_dict[direction], location[2])
    elif action == 'TurnL':
        location = (location[0], location[1], turnl_dict[direction])
    else:
        location = (location[0], location[1], turnr_dict[direction])
    return location


def collision(program1, start1, program2, start2):

    global vehicle1, vehicle2
    len1 = len(program1)
    len2 = len(program2)
    maxlen = max(len1, len2)
    move1 = []
    move2 = []
    if start1[:2]==start2[:2]:
        return tuple(start1[:2])
    for i in range(maxlen):
        if i<len1:
            action1 = program1[i]
            location = start1
            if i>0:
                location=vehicle1
            vehicle1 = move(location, action1)
            print('1',vehicle1)
            move1.append(tuple(vehicle1[:2]))
            print('move1',move1)
        if i<len2:
            action2 = program2[i]
            location = start2
            if i>0:
                location=vehicle2
            vehicle2 = move(location, action2)
            print('2',vehicle2)
            move2.append(tuple(vehicle2[:2]))
            print('move2',move2)

    for j in range(max(len(move1), len(move2))):
        if move1[j] == move2[j]:
            return move1[j]
    return None

print(collision(['Drive', 'TurnR', 'Drive'], (2, 2, 'N'), ['Drive', 'Drive', 'Drive'], (2, 1, 'N')))