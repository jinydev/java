import os
import re
import sys

def fix_svg(filepath):
    with open(filepath, 'r', encoding='utf-8') as f:
        content = f.read()

    style_pattern = re.compile(r'<style>\s*@keyframes fade.*?</style>', re.DOTALL)
    
    if not style_pattern.search(content):
        return False

    new_style = """<style>
    @keyframes fadeIn {
      0% { opacity: 0; }
      100% { opacity: 1; }
    }
    .animated-g {
      opacity: 0;
      animation: fadeIn 0.8s ease-out forwards;
    }
    /* Add sequential delays */
    .animated-g:nth-of-type(1) { animation-delay: 0.1s; }
    .animated-g:nth-of-type(2) { animation-delay: 0.3s; }
    .animated-g:nth-of-type(3) { animation-delay: 0.5s; }
    .animated-g:nth-of-type(4) { animation-delay: 0.7s; }
    .animated-g:nth-of-type(5) { animation-delay: 0.9s; }
    .animated-g:nth-of-type(6) { animation-delay: 1.1s; }
    .animated-g:nth-of-type(7) { animation-delay: 1.3s; }
    .animated-g:nth-of-type(8) { animation-delay: 1.5s; }
    .animated-g:nth-of-type(9) { animation-delay: 1.7s; }
    .animated-g:nth-of-type(10) { animation-delay: 1.9s; }
  </style>"""

    new_content = style_pattern.sub(new_style, content)
    
    if new_content != content:
        with open(filepath, 'w', encoding='utf-8') as f:
            f.write(new_content)
        return True
    return False

target_dir = sys.argv[1]
count = 0
for root, _, files in os.walk(target_dir):
    for file in files:
        if file.endswith('.svg'):
            filepath = os.path.join(root, file)
            if fix_svg(filepath):
                count += 1
                
print(f"Fixed {count} SVG files.")
