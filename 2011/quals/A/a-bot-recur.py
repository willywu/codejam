#! /usr/bin/python

f_in="A-large.in"
f_out="a-out.txt"

def do_puzzle(fp_in):
    line = fp_in.readline().split()
    N = int(line[0])
    line = line[1:]
    o_pos = b_pos = 1
    time = 0
    while len(line) > 0:
        o_pos, b_pos, line = t_step(o_pos, b_pos, line)
        time += 1
    return time
    
CHOP = False

def find_next_pos(curr_pos, color, line):
    """
    Find the next location for the color
    """
    try:
        next_pos_idx = line.index(color)
        next_pos = int(line[next_pos_idx+1])
        if (next_pos > curr_pos):
            return curr_pos+1
        elif (next_pos == curr_pos):
            if (line[0] == color):
                global CHOP
                CHOP = True
            return curr_pos
        else:
            return curr_pos-1
    except ValueError:
        return curr_pos

def t_step(o_pos, b_pos, line):
    next_o = find_next_pos(o_pos, "O", line)
    next_b = find_next_pos(b_pos, "B", line)
    global CHOP
    if CHOP:
        line = line[2:]
        CHOP = False
    return next_o, next_b, line

if __name__ == "__main__":
    fp_in = open(f_in)
    fp_out = open(f_out, 'w')
    T = int(fp_in.readline())

    for i in range(T):
        ans = do_puzzle(fp_in)
        fp_out.write("Case #%s: %s\n" % (i+1, ans))
    fp_in.close()
    fp_out.close()
    
