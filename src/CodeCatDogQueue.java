package src;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用户可以调用add方法将cat类或者dog类的实例放入队列中；
 * 用户可以调用pollAll方法，将队列中所有的实例按照队列的先后顺序依次弹出；
 * 用户可以调用pollDog方法，将队列中dog类的实例按照队列的先后顺序依次弹出；
 * 用户可以调用pollCat方法，将队列中cat类的实例按照队列的先后顺序依次弹出；
 * 用户可以调用isEmpty方法，检查队列中是否还有dog和cat的实例；
 * 用户可以调用isDogEmpty方法，检查队列中是否还有dog的实例；
 * 用户可以调用isCatEmpty方法，检查队列中是否还有cat的实例。
 *
 */
public class CodeCatDogQueue {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("Dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("Cat");
        }
    }

    public static class PetEnter {
        private Pet pet;
        private long count;

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getPetType() {
            return this.pet.getType();
        }
    }

    public static class DogCatQueue {
        private Queue<PetEnter> dogQueue;
        private Queue<PetEnter> catQueue;
        private long count;

        public DogCatQueue() {
            this.dogQueue = new LinkedList<PetEnter>();
            this.catQueue = new LinkedList<PetEnter>();
            this.count = 0;
        }

        public void add(Pet pet) {
            if (pet.getType().equals("Dog")) {
                this.dogQueue.add(new PetEnter(pet, this.count++));
            } else if (pet.getType().equals("Cat")) {
                this.catQueue.add(new PetEnter(pet, this.count++));
            } else {
                throw new RuntimeException("No dog or cat !!!");
            }
        }

        public Pet pollAll() {
            if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
                if (this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()) {
                    return this.dogQueue.poll().getPet();
                }else {
                    return this.catQueue.poll().getPet();
                }
            } else if (!this.dogQueue.isEmpty()) {
                return this.dogQueue.poll().getPet();
            } else if (!this.catQueue.isEmpty()) {
                return this.catQueue.poll().getPet();
            } else {
                throw new RuntimeException("The queue is empty!");
            }
        }

        public Dog pollDog() {
            if (!this.dogQueue.isEmpty()) {
                return (Dog) this.dogQueue.poll().getPet();
            } else {
                throw new RuntimeException("The dogQueue is empty");
            }
        }

        public Cat pollCat() {
            if (!this.catQueue.isEmpty()) {
                return (Cat) this.catQueue.poll().getPet();
            } else {
                throw new RuntimeException("The catQueue is empty");
            }
        }

        public boolean isEmpty() {
            return (this.dogQueue.isEmpty() && this.catQueue.isEmpty());
        }

        public boolean isDogEmpty() {
            return this.dogQueue.isEmpty();
        }

        public boolean isCatEmpty() {
            return this.catQueue.isEmpty();
        }

        public static void main(String[] args) {
            DogCatQueue dogCatQueue = new DogCatQueue();

            Pet dog1 = new Dog();
            Pet dog2 = new Dog();
            Pet dog3 = new Dog();
            Cat cat1 = new Cat();
            Cat cat2 = new Cat();
            Cat cat3 = new Cat();

            dogCatQueue.add(dog1);
            dogCatQueue.add(dog2);
            dogCatQueue.add(cat1);
            dogCatQueue.add(cat2);
            dogCatQueue.add(cat3);

            System.out.println(dogCatQueue.pollAll().getType());  //dog1.getType()
            System.out.println(dogCatQueue.pollCat().getType());  //cat1.getType()
            dogCatQueue.add(dog3);
            System.out.println(dogCatQueue.pollDog().getType());  //dog2.getType()
            System.out.println(dogCatQueue.isDogEmpty());         //false
            System.out.println(dogCatQueue.pollDog().getType());  //dog3.getType()
            System.out.println(dogCatQueue.isDogEmpty());         //true
        }


    }


}

