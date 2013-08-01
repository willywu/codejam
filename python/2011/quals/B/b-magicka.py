#! /usr/bin/python

f_in="B-large.in"
f_out="b-out.txt"

def do_puzzle(fp_in):
    line = fp_in.readline().split()

    TRANS_RULE = {} # hash of ["ab"] -> "c"
    n_trans = int(line.pop(0))
    for i in range(n_trans):
        rule = line.pop(0)
        TRANS_RULE[rule[0] + rule[1]] = rule[2]
        TRANS_RULE[rule[1] + rule[0]] = rule[2]
    #print("trans rule: %s" % TRANS_RULE)
    
    CLEAR_RULES = {} # hash of ["a"] -> list of opposed chars
    n_clears = int(line.pop(0))
    for i in range(n_clears):
        clear = line.pop(0)
        if clear[0] not in CLEAR_RULES:
            CLEAR_RULES[clear[0]] = []
        exist_rules = CLEAR_RULES[clear[0]]
        exist_rules.append(clear[1])
        CLEAR_RULES[clear[0]] = exist_rules
        if clear[1] not in CLEAR_RULES:
            CLEAR_RULES[clear[1]] = []
        exist_rules = CLEAR_RULES[clear[1]]
        exist_rules.append(clear[0])
        CLEAR_RULES[clear[1]] = exist_rules
    #print("clear rules: %s" % CLEAR_RULES)
        
    elem_list = []
    series = line[1]
    #print("series: %s" % series)
    for elem in series:
        elem_list.append(elem)
        
        if len(elem_list) < 2:
            continue
            
        # check for replacement
        key = elem_list[-1] + elem_list[-2]
        if key in TRANS_RULE:
            elem_list = elem_list[0:-2] + [TRANS_RULE[key]]
            continue
        
        # check for clear
        if elem not in CLEAR_RULES:
            continue
        clear_candidates = CLEAR_RULES[elem]
        for exist_elem in elem_list[0:-1]:
            if exist_elem in clear_candidates:
                elem_list = []
                break
        #print(elem_list)
    return "[" + ", ".join(elem_list) + "]"

if __name__ == "__main__":
    fp_in = open(f_in)
    fp_out = open(f_out, 'w')
    T = int(fp_in.readline())
    for i in range(T):
        ans = do_puzzle(fp_in)
        fp_out.write("Case #%s: %s\n" % (i+1, ans))
    fp_in.close()
    fp_out.close()
    
