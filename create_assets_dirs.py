import os

def create_assets_dirs():
    root_dir = 'src'
    skip_dirs = {'_data', '_includes', '_layouts', '_site', '_sass', 'assets', 'img', 'src', '.git'}

    for root, dirs, files in os.walk(root_dir):
        # Modify dirs in-place to skip traversing into ignored dirs
        dirs[:] = [d for d in dirs if d not in skip_dirs and not d.startswith('.')]
        
        # We are now in a potential chapter directory (including src itself, but we probably don't want img/src in src root? User said "Chapter folders")
        if root == 'src':
            continue
            
        # Create img and src folders
        for folder in ['img', 'src']:
            target_path = os.path.join(root, folder)
            if not os.path.exists(target_path):
                print(f"Creating {target_path}")
                os.makedirs(target_path)

if __name__ == "__main__":
    create_assets_dirs()
