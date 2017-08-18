def get_self_number(num, standard):
  sum = num
  for letter in str(num):
    sum += int(letter)
  
  return sum if(standard >= sum) else 0

num_arr = range(1, 10001)
num_list = []

for num in num_arr:
  self_number = get_self_number(num, 10000)
  if(self_number > 0):
    num_list.append(self_number)
 
# print(set(num_list))
result_sort = sorted(set(num_arr) - set(num_list))
for i in result_sort:
  print(i)




